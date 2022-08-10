package com.websystem.websystem.model;

import com.websystem.websystem.enums.ModoPagamento;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Double valorTotal;
    private ModoPagamento modoPagamento;

    @Transient
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
