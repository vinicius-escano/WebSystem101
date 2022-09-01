package com.websystem.websystem.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nomeBanco;

    public Banco(int codigo, String nomeBanco) {
        this.codigo = codigo;
        this.nomeBanco = nomeBanco;
    }

    public Banco(){};

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}
