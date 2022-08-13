package com.websystem.websystem.model;

import com.websystem.websystem.enums.CompraDestino;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCompra {

    private CompraDestino destino;
    private List<Produto> listProdutos;

    public PedidoCompra(List<Produto> produtoList){
        this.listProdutos = produtoList;
    }

}
