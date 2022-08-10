package com.websystem.websystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_contatos")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String numeroTelefone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
