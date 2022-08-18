package com.websystem.websystem.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime cadastrado = LocalDateTime.now();
    private String cadastradoPor;
    private LocalDateTime alterado;
    private String alteradoPor;

    @Transient
    private List<Produto> produtoList;

}
