package com.websystem.websystem.model;

import com.websystem.websystem.enums.ModoPagamento;
import com.websystem.websystem.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    private VendaStatus vendaStatus = VendaStatus.EM_ABERTO;
    private LocalDateTime cadastrado = LocalDateTime.now();
    private String cadastradoPor;
    private LocalDateTime alterado;
    private String alteradoPor;

    @Transient
    private List<Produto> listProdutos;
    @Transient
    private boolean devolucao = false;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Venda(List<Produto> list){
        this.listProdutos = list;
    }

}
