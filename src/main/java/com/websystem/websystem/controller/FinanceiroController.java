package com.websystem.websystem.controller;

import com.websystem.websystem.model.Venda;
import com.websystem.websystem.service.CompraService;
import com.websystem.websystem.service.FinanceiroService;
import com.websystem.websystem.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private CompraService compraService;

    @GetMapping("/financeiro")
    public ModelAndView financeiroOpcoes(){
        return new ModelAndView("financeiro-opcoes");
    }

    @GetMapping("/devolucaodepositobancario")
    public ModelAndView devolucoesPendentes(){
        return new ModelAndView("devolucoes-depositos").addObject("devolucoes", financeiroService.buscaDevolucaoDepositoBancarioEmAberto());
    }

    @GetMapping("/relacaocaixa")
    public ModelAndView relacaoCaixa(){
        return new ModelAndView("relacao-caixa");
    }

    @RequestMapping(value = "/buscarelacaocaixa", params = {"dataInicio", "dataFim", "buscaCaixa"})
    public ModelAndView buscaRelacaoCaixa(@RequestParam("dataInicio") String dataInicio, @RequestParam("dataFim") String dataFim){
        List<Venda> listVendas =  vendaService.buscaPorPeriodo(dataInicio, dataFim);
        return new ModelAndView("relacao-caixa");
    }
}
