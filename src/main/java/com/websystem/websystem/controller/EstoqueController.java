package com.websystem.websystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EstoqueController {

    @GetMapping("/estoque")
    public ModelAndView estoqueOpcoes(){
        return new ModelAndView("estoque-opcoes");
    }

    @GetMapping("/cadastrarproduto")
    public ModelAndView cadastrarProduto(){
        return null;
    }

    @GetMapping("/editarproduto")
    public ModelAndView editarProduto(){
        return null;
    }

    @GetMapping("/visualizartudo")
    public ModelAndView visualizarTudo(){
        return null;
    }

}
