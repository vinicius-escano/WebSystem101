package com.websystem.websystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Double valorCompra;
    private Integer codigoNota;

    @Transient
    private List<Produto> produtoList;
}
