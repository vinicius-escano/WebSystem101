package com.websystem.websystem.model;

import com.websystem.websystem.enums.CompraDestino;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedidoCompra")
public class PedidoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private CompraDestino destino;
    private String observacao;

    @Transient
    private List<Produto> listProdutos;

    public PedidoCompra(List<Produto> produtoList){
        this.listProdutos = produtoList;
    }

}
