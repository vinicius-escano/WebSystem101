package com.websystem.websystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SqlResultSetMapping(name = "DevolucaoDepositoBancarioDTOResults", classes = {
        @ConstructorResult(targetClass = DevolucaoDepositoBancarioDTO.class, columns = {
                @ColumnResult(name = "CODIGO", type = Integer.class),
                @ColumnResult(name = "DEVOLUCAO_CODIGO", type = Integer.class),
                @ColumnResult(name = "BANCO_CODIGO",type = Integer.class),
                @ColumnResult(name = "AGENCIA_NUMERO", type = Integer.class),
                @ColumnResult(name = "CONTA_NUMERO", type = Integer.class)})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DevolucaoDepositoBancarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private Integer devolucaoCodigo;
    private Integer bancoCodigo;
    private Integer agenciaNumero;
    private Integer contaNumero;
}
