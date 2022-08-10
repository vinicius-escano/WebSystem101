package com.websystem.websystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;
    private String cpfCnpj;

    @OneToMany(mappedBy = "cliente")
    private List<Contatos> contatos;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;
}
