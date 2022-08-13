package com.websystem.websystem.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Endereco(int codigo, String logradouro, String bairro, String uf, Integer numero, String cidade, String cep) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
    }
}
