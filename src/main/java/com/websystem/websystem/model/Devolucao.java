package com.websystem.websystem.model;

import com.websystem.websystem.repository.VendaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_devolucao")
public class Devolucao extends Venda {

    @Autowired
    VendaRepository vendaRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private int vendaOrigemCodigo;
    private double valorDevolucao;
    private LocalDateTime cadastrado = LocalDateTime.now();
    private String cadastradoPor;
    private LocalDateTime alterado;
    private String alteradoPor;

    @Transient
    private Venda venda;

    @Transient
    private List<Produto> produtosDevolver = new ArrayList<>();

    public boolean setVenda() {
        Optional<Venda> opVenda = vendaRepository.findById(vendaOrigemCodigo);
        if (opVenda.isPresent()){
            venda = opVenda.get();
            return true;
        }
        return false;
    }


}
