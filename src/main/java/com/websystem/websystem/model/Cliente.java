package com.websystem.websystem.model;

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
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;
    private String cpfCnpj;

    @OneToMany(mappedBy = "cliente")
    private List<Contatos> listContatos;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> listEnderecos;
}
