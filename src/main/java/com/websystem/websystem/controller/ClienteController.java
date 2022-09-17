package com.websystem.websystem.controller;

import com.websystem.websystem.model.Cliente;
import com.websystem.websystem.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView carregaPaginaClientes(){
        return new ModelAndView("clientes").addObject("clientes", clienteService.getAll());
    }

    @GetMapping("/novocliente")
    public ModelAndView cadastrarCliente(){
        return new ModelAndView("ficha-cliente").addObject("isNovo", true).addObject("cliente", new Cliente());
    }

    @RequestMapping(value = "/acessarcliente", params = {"id"})
    public ModelAndView acessarCadastroCliente(@RequestParam("id") String id){
        Optional<Cliente> opCliente = clienteService.findById(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("ficha-cliente");
        modelAndView.addObject("cliente", opCliente.get()).addObject("editar", false);
        return modelAndView;
    }

    @RequestMapping(value = "/editarcliente", params = {"id"})
    public ModelAndView editarCadastroCliente(@RequestParam("id") String id){
        Optional<Cliente> opCliente = clienteService.findById(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("ficha-cliente");
        modelAndView.addObject("cliente", opCliente.get()).addObject("editar", true);
        return modelAndView;
    }
}
