package com.websystem.websystem.service;

import com.websystem.websystem.model.Produto;
import com.websystem.websystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private CustomQueryService queryService;

    public List<Produto> findAllByPedidoCompraCodigo(int codigoPedido){
        List<Integer> codigosProdutos = queryService.buscaItens(codigoPedido);
        return produtoRepository.listByPedidoCompra(codigosProdutos);
    }

    

}
