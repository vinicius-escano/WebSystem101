package com.websystem.websystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CompraController {

    @GetMapping("/comprar")
    public ModelAndView comprarOpcoes(){
        return new ModelAndView("comprar-opcoes");
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
