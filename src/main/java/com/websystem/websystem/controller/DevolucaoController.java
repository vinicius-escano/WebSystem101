package com.websystem.websystem.controller;

import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.model.Venda;
import com.websystem.websystem.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class DevolucaoController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/devolucao")
    public ModelAndView abrirDevolucao(){
        return new ModelAndView("devolucao").addObject("devolucao", new Devolucao());
    }

    @RequestMapping(value = "/cadastrardevolucao", params = {"codigoVenda"})
    public ModelAndView buscarVenda(@RequestParam("codigoVenda")Integer codigoVenda, HttpServletRequest httpServletRequest){
        Optional<Venda> opVenda = vendaService.buscaVenda(codigoVenda);
        if(opVenda.isPresent()){
            Devolucao devolucao = new Devolucao();
            devolucao.setVendaOrigemCodigo(codigoVenda);
            devolucao.setVenda(opVenda.get());
            httpServletRequest.getSession().setAttribute("devolucao", devolucao);
            return new ModelAndView("devolucao").addObject("devolucao", devolucao);
        }
        return new ModelAndView("devolucao").addObject("devolucao", new Devolucao());
    }

}
