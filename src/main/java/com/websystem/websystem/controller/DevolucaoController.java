package com.websystem.websystem.controller;

import com.websystem.websystem.model.Banco;
import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.model.Venda;
import com.websystem.websystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class DevolucaoController {

    @Autowired
    private DevolucaoService devolucaoService;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BancoService bancoService;

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
            devolucao.getVenda().setListProdutos(produtoService.findAllFromVendas(codigoVenda));
            devolucao.setCliente(opVenda.get().getCliente());
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
            devolucao.getVenda().getListProdutos().get(Integer.valueOf(indexCodigo)).setQuantidadeVenda(opProduto.get().getQuantidadeVenda() - Integer.valueOf(qtdeDevolver));
            httpServletRequest.getSession().setAttribute("devolucao", devolucao);
            return new ModelAndView("devolucao").addObject("devolucao", devolucao);
        }
        return new ModelAndView("devolucao").addObject("devolucao", new Devolucao());
    }

    @PostMapping("/confirmardevolucao")
    public ModelAndView confirmaEstornoValores(HttpServletRequest httpServletRequest) {
        Devolucao devolucao = (Devolucao) httpServletRequest.getSession().getAttribute("devolucao");
        devolucaoService.calculaDevolucao(devolucao);
        List<Banco> listBancos = bancoService.findAll();
        return new ModelAndView("confirmacao-devolucao").addObject("devolucao", devolucao).addObject("bancos", listBancos);
    }

    @RequestMapping(value = "/cadastrardevolucao", params = {"depositoBancario"})
    public ModelAndView cadastraDevolucaoCreditoEmConta(@RequestParam("codigoBanco") Integer codigoBanco,
                                                        @RequestParam("agencia") Integer agencia,
                                                        @RequestParam("conta") Integer numero,
                                                        HttpServletRequest httpServletRequest) {
        Devolucao devolucao = (Devolucao) httpServletRequest.getSession().getAttribute("devolucao");
        devolucao = devolucaoService.save(devolucao);
        Optional<Banco> opBanco = bancoService.findById(codigoBanco);
        if (opBanco.isPresent()) {
            if (bancoService.registraDevolucaoPorDeposito(devolucao.getCliente(), opBanco.get(), devolucao, agencia, numero)) {
                return new ModelAndView("home");
            }
        }
        return null;

    }

    @RequestMapping(value = "/cadastrardevolucao", params = {"creditoEmConta"})
    public ModelAndView cadastraDevolucaoDepositoBancario(HttpServletRequest httpServletRequest) {
        Devolucao devolucao = (Devolucao) httpServletRequest.getSession().getAttribute("devolucao");
        devolucao = devolucaoService.save(devolucao);
        if (clienteService.insereCreditoEmConta(devolucao.getCliente(), devolucao.getValorDevolucao())) {
            return new ModelAndView("home");
        }
        return null;
    }


}
