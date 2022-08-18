package com.websystem.websystem.model;

import com.websystem.websystem.enums.ProdutoGrupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String descricao;
    private Double valor;
    private Integer quantidade;
    private Integer imposto;
    private ProdutoGrupo grupo;
    private LocalDateTime cadastrado = LocalDateTime.now();
    private String cadastradoPor;
    private LocalDateTime alterado;
    private String alteradoPor;

    @Transient
    private Integer quantidadeVenda;
    @Transient
    private Double valorTotalEmVenda;
    @Transient
    private Integer quantidadeDevolver;

}
