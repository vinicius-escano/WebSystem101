package com.websystem.websystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String logradouro;
    private String bairro;
    private String uf;
    private Integer numero;
    private String cidade;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
