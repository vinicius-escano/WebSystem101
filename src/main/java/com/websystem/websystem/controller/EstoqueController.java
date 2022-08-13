package com.websystem.websystem.controller;

import com.websystem.websystem.model.Produto;
import com.websystem.websystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class EstoqueController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/estoque")
    public ModelAndView estoqueOpcoes(){
        return new ModelAndView("estoque-opcoes");
    }

    @GetMapping("/cadastrarproduto")
    public ModelAndView cadastrarProduto(){
        return new ModelAndView("produto").addObject("produto", new Produto());
    }

    @PostMapping("/novoproduto")
    public ModelAndView salvarNovoProduto(Produto produto){
        produtoRepository.save(produto);
        return new ModelAndView("home");
    }

    @GetMapping("/editarproduto")
    public ModelAndView listProdutos(){
        List<Produto> produtoList = produtoRepository.findAll();
        return new ModelAndView("estoque").addObject("produtos", produtoList);
    }

    @RequestMapping(value = "/acessarproduto", params = ("id"))
    public ModelAndView editarProduto(@RequestParam("id") String id){
        Optional<Produto> opProduto = produtoRepository.findById(Integer.valueOf(id));
        if(opProduto.isPresent()) {
            return new ModelAndView("produto").addObject("produto", opProduto.get());
        }
        return null;
    }

    @GetMapping("/visualizartudo")
    public ModelAndView visualizarTudo(){
        return null;
    }

}
