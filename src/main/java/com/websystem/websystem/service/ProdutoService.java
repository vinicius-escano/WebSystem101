package com.websystem.websystem.service;

import com.websystem.websystem.dto.ProdutoVendaDTO;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.repository.CustomQueryRepository;
import com.websystem.websystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private CustomQueryRepository queryService;

    public List<Produto> findAllByPedidoCompraCodigo(int codigoPedido){
        List<Integer> codigosProdutos = queryService.buscaItensFromProdutosPedidosCompras(codigoPedido);
        return produtoRepository.listByReference(codigosProdutos);
    }

    public Optional<Produto> findById(int codigoItem){
        return produtoRepository.findById(codigoItem);
    }

    public List<Produto> findAllFromVendas(int codigoPedido){
        List<ProdutoVendaDTO> produtosVendaDTO = queryService.buscaItensFromVendas(codigoPedido);
        List<Integer> codigosProdutos = new ArrayList<>();
        produtosVendaDTO.stream().forEach(p ->{
            codigosProdutos.add(p.getProdutoCodigo());
        });
        List<Produto> produtos = produtoRepository.listByReference(codigosProdutos);
        for(Produto p: produtos){
            produtosVendaDTO.stream().forEach(pdto -> {
                if(pdto.getProdutoCodigo() == p.getCodigo()){
                    p.setQuantidadeVenda(pdto.getProdutoQuantidade());
                    p.setValorTotalEmVenda(pdto.getValorTotal());
                }
            });
        }
        return produtos;
    }

    

}
