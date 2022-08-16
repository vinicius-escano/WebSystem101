package com.websystem.websystem.controller;

import com.websystem.websystem.model.PedidoCompra;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.repository.PedidoCompraRepository;
import com.websystem.websystem.repository.ProdutoRepository;
import com.websystem.websystem.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoCompraRepository pedidoCompraRepository;

    @Autowired
    private ProdutoService produtoService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/comprar")
    public ModelAndView comprarOpcoes() {
        return new ModelAndView("comprar-opcoes");
    }

    @GetMapping("/gerarpedido")
    public ModelAndView novoPedido(HttpServletRequest httpServletRequest) {
        PedidoCompra pedidoCompra = new PedidoCompra(new ArrayList<>());
        httpServletRequest.getSession().setAttribute("pedido-compra", pedidoCompra);
        return new ModelAndView("pedido-compra").addObject("pedidoCompra", pedidoCompra);
    }

    @RequestMapping(value = "/novopedido", params = {"addItem"})
    public ModelAndView adicionaProduto(@RequestParam("itemCodigo") Integer codigo, @RequestParam("quantidade") Integer quantidade, HttpServletRequest httpServletRequest) {
        Optional<Produto> opProduto = produtoRepository.findById(Integer.valueOf(codigo));
        if (opProduto.isPresent()) {
            PedidoCompra pedidoCompra = (PedidoCompra) httpServletRequest.getSession().getAttribute("pedido-compra");
            opProduto.get().setQuantidade(quantidade);
            if (pedidoCompra.getListProdutos() == null) {
                pedidoCompra.setListProdutos(new ArrayList<>());
            }
            pedidoCompra.getListProdutos().add(opProduto.get());
            return new ModelAndView("pedido-compra").addObject("pedidoCompra", pedidoCompra);
        }
        return null;
    }

    @RequestMapping(value = "/novopedido", params = {"removeItemNumero"})
    public ModelAndView removeProduto(@RequestParam("removeItemNumero") Integer itemNumero, HttpServletRequest httpServletRequest) {
        PedidoCompra pedidoCompra = (PedidoCompra) httpServletRequest.getSession().getAttribute("pedido-compra");
        pedidoCompra.getListProdutos().remove(pedidoCompra.getListProdutos().get(itemNumero));
        return new ModelAndView("pedido-compra").addObject("pedidoCompra", pedidoCompra);
    }

    @PostMapping(value = "/novopedido", consumes = "application/x-www-form-urlencoded")
    public ModelAndView salvaPedido(PedidoCompra pedidoCompra, HttpServletRequest httpServletRequest) {
        PedidoCompra pedidoSession = (PedidoCompra) httpServletRequest.getSession().getAttribute("pedido-compra");
        pedidoCompra.setListProdutos(pedidoSession.getListProdutos());
        PedidoCompra saved = pedidoCompraRepository.save(pedidoCompra);
        for(Produto p: pedidoCompra.getListProdutos()){
            pedidoCompraRepository.insert(saved.getCodigo(), p.getCodigo(), entityManager);
        }
        return new ModelAndView("comprar-opcoes");
    }

    @GetMapping("/visualizarpedidos")
    public ModelAndView visualizarTodos() {
        List<PedidoCompra> listPedidos =  pedidoCompraRepository.findAll();
        return new ModelAndView("pedidos-compra").addObject("listPedidos", listPedidos);
    }

    @RequestMapping(value = "/acessarpedido", params = {"id"})
    public ModelAndView entradaProduto(@RequestParam("id") Integer id) {
        Optional<PedidoCompra> opPedidoCompra = pedidoCompraRepository.findById(id);
        if(opPedidoCompra.isPresent()){
            opPedidoCompra.get().setListProdutos(produtoService.findAllByPedidoCompraCodigo(id));
            return new ModelAndView("pedido-compra").addObject("pedidoCompra", opPedidoCompra.get());
        }
        return null;
    }

    @GetMapping("/pedidosCompra")
    public ModelAndView pedidosPendentes() {
        return null;
    }
}
