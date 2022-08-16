package com.websystem.websystem.model;

import com.websystem.websystem.enums.ModoPagamento;
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
@Table(name = "tb_vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Double valorTotal = 0.0;
    private ModoPagamento modoPagamento;

    @Transient
    private List<Produto> listProdutos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    public Venda(List<Produto> list){
        this.listProdutos = list;
    }

}
