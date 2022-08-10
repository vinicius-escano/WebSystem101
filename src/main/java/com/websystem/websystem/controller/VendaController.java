package com.websystem.websystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class VendaController {

    @GetMapping("/vender")
    public ModelAndView vender(){
        return new ModelAndView("vender");
    }

}
