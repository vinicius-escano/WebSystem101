package com.websystem.websystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministracaoController {

    @GetMapping("/administracao")
    public ModelAndView administracaoOpcoes(){
        return new ModelAndView("administracao-opcoes");
    }

    @GetMapping("/controleusuarios")
    public ModelAndView controleUsuarios(){
        return null;
    }

    @GetMapping("/relatoriofinanceiro")
    public ModelAndView relatorioFinanceiro(){
        return null;
    }

    @GetMapping("/relatoriovendas")
    public ModelAndView relatorioVendas(){
        return null;
    }

    @GetMapping("/relatorioCompras")
    public ModelAndView relatorioCompras(){
        return null;
    }

}
