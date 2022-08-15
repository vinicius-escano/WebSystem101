package com.websystem.websystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Integer pedidoCodigo;
    private Double valorCompra;
    private Integer codigoNota;

    @Transient
    private List<Produto> produtoList;

}
