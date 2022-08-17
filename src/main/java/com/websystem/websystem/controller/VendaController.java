package com.websystem.websystem.controller;

import com.websystem.websystem.enums.ModoPagamento;
import com.websystem.websystem.enums.VendaStatus;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.model.Venda;
import com.websystem.websystem.repository.ProdutoRepository;
import com.websystem.websystem.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class VendaController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaService vendaService;

    @GetMapping("/vender")
    public ModelAndView vender(HttpServletRequest httpServletRequest) {
        Venda venda = new Venda(new ArrayList<>());
        httpServletRequest.getSession().setAttribute("venda", venda);
        return new ModelAndView("vender").addObject("venda", venda);
    }

    @RequestMapping(value = "/efetivar", params = {"buscaItem","codigoItem", "quantidadeItem"})
    public ModelAndView adicionarItem(@RequestParam("codigoItem") Integer codigoItem, @RequestParam("quantidadeItem") Integer quantidadeItem, HttpServletRequest httpServletRequest){
        Venda venda = (Venda) httpServletRequest.getSession().getAttribute("venda");
        Optional<Produto> opProduto = produtoRepository.findById(codigoItem);
        if(opProduto.isPresent()){
            opProduto.get().setQuantidadeVenda(quantidadeItem);
            opProduto.get().setValorTotalEmVenda(quantidadeItem * opProduto.get().getValor());
            venda.setValorTotal(venda.getValorTotal() + opProduto.get().getValorTotalEmVenda());
            venda.getListProdutos().add(opProduto.get());
        }
        return new ModelAndView("vender").addObject("venda", venda);
    }

    @RequestMapping(value = "/efetivar", params = {"removeItemNumero"})
    public ModelAndView adicionarItem(@RequestParam("removeItemNumero") Integer codigoItem, HttpServletRequest httpServletRequest){
        Venda venda = (Venda) httpServletRequest.getSession().getAttribute("venda");
        venda.setValorTotal(venda.getValorTotal() - venda.getListProdutos().get(codigoItem).getValorTotalEmVenda());
        venda.getListProdutos().remove(venda.getListProdutos().get(codigoItem));
        return new ModelAndView("vender").addObject("venda", venda);
    }

    @PostMapping("/efetivar")
    public ModelAndView adicionarItem(HttpServletRequest httpServletRequest){
        Venda venda = (Venda) httpServletRequest.getSession().getAttribute("venda");
        Venda savedVenda = vendaService.salvarVenda(venda);
        vendaService.salvarItensReferenciaVenda(savedVenda.getCodigo(), venda.getListProdutos());
        return new ModelAndView("modo-pagamento").addObject("venda", savedVenda);
    }

    @PostMapping("/confirmavenda")
    public ModelAndView confirmaVenda(HttpServletRequest httpServletRequest){
        Venda venda = (Venda) httpServletRequest.getSession().getAttribute("venda");
        venda.setVendaStatus(VendaStatus.FECHADO);
        vendaService.alteraStatusVenda(venda);
        return new ModelAndView("home");
    }

}
