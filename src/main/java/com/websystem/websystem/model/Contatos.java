package com.websystem.websystem.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Contatos(int codigo, String numeroTelefone, String email) {
        this.codigo = codigo;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
    }
}
