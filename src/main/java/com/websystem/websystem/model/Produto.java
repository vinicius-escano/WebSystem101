package com.websystem.websystem.model;

import com.websystem.websystem.enums.ProdutoGrupo;
import lombok.Data;

import javax.persistence.*;

@Data
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
}
