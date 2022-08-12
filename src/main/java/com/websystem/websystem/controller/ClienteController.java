package com.websystem.websystem.controller;

import com.websystem.websystem.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.websystem.websystem.service.ClienteService;

import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView carregaPaginaClientes(){
        return new ModelAndView("clientes").addObject("clientes", clienteService.getAll());
    }

    @GetMapping("/cadastrarcliente")
    public ModelAndView cadastrarCliente(){
        return new ModelAndView("ficha-cliente").addObject("isNovo", true);
    }

    @RequestMapping(value = "/acessarCliente", params = {"id"})
    public ModelAndView acessarCadastroCliente(@RequestParam("id") String id){
        Optional<Cliente> opCliente = clienteService.findById(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("ficha-cliente");
        modelAndView.addObject("cliente", opCliente.get());
        return modelAndView;
    }
}
