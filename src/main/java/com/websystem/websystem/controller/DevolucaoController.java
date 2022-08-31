package com.websystem.websystem.controller;

import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.model.Venda;
import com.websystem.websystem.service.DevolucaoService;
import com.websystem.websystem.service.ProdutoService;
import com.websystem.websystem.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class DevolucaoController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private DevolucaoService devolucaoService;

    @GetMapping("/devolucao")
    public ModelAndView abrirDevolucao() {
        return new ModelAndView("devolucao").addObject("devolucao", new Devolucao());
    }

    @GetMapping("/buscavenda")
    public ModelAndView buscarVenda(@RequestParam("codigoVenda") Integer codigoVenda, HttpServletRequest httpServletRequest) {
        Optional<Venda> opVenda = vendaService.buscaVenda(codigoVenda);
        if (opVenda.isPresent()) {
            Devolucao devolucao = new Devolucao();
            devolucao.setVendaOrigemCodigo(codigoVenda);
            devolucao.setVenda(opVenda.get());
            devolucao.setListProdutos(produtoService.findAllFromVendas(codigoVenda));
            httpServletRequest.getSession().setAttribute("devolucao", devolucao);
            return new ModelAndView("devolucao").addObject("devolucao", devolucao);
        }
        return new ModelAndView("devolucao").addObject("devolucao", new Devolucao());
    }

    @GetMapping("/additemdevolucao")
    public ModelAndView adicionarItemDevolucao(@RequestParam("quantidade") String qtdeDevolver, @RequestParam("index") String indexCodigo, HttpServletRequest httpServletRequest) {
        Devolucao devolucao = (Devolucao) httpServletRequest.getSession().getAttribute("devolucao");
        Optional<Produto> opProduto = devolucao.buscaProdutoDaLista(Integer.valueOf(indexCodigo));
        if (opProduto.isPresent()) {
            opProduto.get().setQuantidadeDevolver(Integer.valueOf(qtdeDevolver));
            devolucao.getProdutosDevolver().add(opProduto.get());
            devolucao.getListProdutos().remove(devolucao.getListProdutos().get(Integer.valueOf(indexCodigo)));
            httpServletRequest.getSession().setAttribute("devolucao", devolucao);
            return new ModelAndView("devolucao").addObject("devolucao", devolucao);
        }
        return new ModelAndView("devolucao").addObject("devolucao", new Devolucao());
    }

    @PostMapping("/confirmardevolucao")
    public ModelAndView confirmaEstornoValores(@RequestParam("modoDevolucao") String modoDevolucao, HttpServletRequest httpServletRequest){
        Devolucao devolucao = (Devolucao) httpServletRequest.getSession().getAttribute("devolucao");
        devolucaoService.calculaDevolucao(devolucao);
        return new ModelAndView("confirmacao-devolucao").addObject("devolucao", devolucao);
    }


}
