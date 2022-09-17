package com.websystem.websystem.model;

import com.websystem.websystem.enums.CompraDestino;
import com.websystem.websystem.enums.StatusAprovacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private StatusAprovacao status = StatusAprovacao.EM_ABERTO;
    private String aprovador;
    private String observacao;
    private LocalDateTime cadastrado = LocalDateTime.now();
    private String cadastradoPor;
    private LocalDateTime alterado;
    private String alteradoPor;

    @Transient
    private List<Produto> listProdutos;

    public PedidoCompra(List<Produto> produtoList){
        this.listProdutos = produtoList;
    }

}
