package com.websystem.websystem.model;

import com.websystem.websystem.repository.VendaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
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

    @Transient
    private Venda venda;

    @Transient
    private List<Produto> produtosDevolver;

    public boolean setVenda() {
        Optional<Venda> opVenda = vendaRepository.findById(vendaOrigemCodigo);
        if (opVenda.isPresent()){
            venda = opVenda.get();
            return true;
        }
        return false;
    }


}
