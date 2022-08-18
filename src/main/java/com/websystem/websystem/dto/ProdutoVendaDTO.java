package com.websystem.websystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SqlResultSetMapping(name = "ProdutoDTOResults", classes = {
        @ConstructorResult(targetClass = ProdutoVendaDTO.class, columns = {
                @ColumnResult(name = "CODIGO", type = Integer.class),
                @ColumnResult(name = "VENDA_CODIGO", type = Integer.class),
                @ColumnResult(name = "PRODUTO_CODIGO",type = Integer.class),
                @ColumnResult(name = "PRODUTO_QUANTIDADE", type = Integer.class),
                @ColumnResult(name = "PRODUTO_VALOR_TOTAL", type = Double.class)})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProdutoVendaDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoDTO;
    private Integer vendaCodigo;
    private Integer produtoCodigo;
    private Integer produtoQuantidade;
    private Double valorTotal;

}
