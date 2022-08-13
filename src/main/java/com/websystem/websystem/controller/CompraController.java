package com.websystem.websystem.controller;

import com.websystem.websystem.model.PedidoCompra;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CompraController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/comprar")
    public ModelAndView comprarOpcoes(){
        return new ModelAndView("comprar-opcoes");
    }

    @GetMapping("/novopedido")
    public ModelAndView novoPedido(){
        return new ModelAndView("pedido-compra").addObject("pedidoCompra", new PedidoCompra(new ArrayList<>()));
    }

    @RequestMapping(value = "/novoproduto", params = {"addItem"})
    public ModelAndView adicionaProduto(PedidoCompra pedidoCompra, @RequestParam("itemCodigo") String codigo, @RequestParam("quantidade") String quantidade, BindingResult bindingResult){
        Optional<Produto> opProduto = produtoRepository.findById(Integer.valueOf(codigo));
        if(opProduto.isPresent()){
            opProduto.get().setQuantidade(Integer.valueOf(quantidade));
            if(pedidoCompra.getListProdutos() == null){
                pedidoCompra.setListProdutos(new ArrayList<>());
            }
            pedidoCompra.getListProdutos().add(opProduto.get());
            return new ModelAndView("pedido-compra").addObject("pedidoCompra", pedidoCompra);
        }
        return null;
    }


    @GetMapping("/cadastrarpedidocompra")
    public ModelAndView cadatrarPedidoCompra(){
        return null;
    }

    @GetMapping("/entradaproduto")
    public ModelAndView entradaProduto(){
        return null;
    }

    @GetMapping("/pedidosCompra")
    public ModelAndView pedidosPendentes(){
        return null;
    }
}
