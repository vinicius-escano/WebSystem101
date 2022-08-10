package com.websystem.websystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @Autowired
    private ClienteController clienteController;

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

}
