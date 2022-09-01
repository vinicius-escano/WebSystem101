package com.websystem.websystem.service;

import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.repository.DevolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucaoService {

    @Autowired
    DevolucaoRepository devolucaoRepository;

    public void calculaDevolucao(Devolucao devolucao) {
        double valorTotal = 0.0;
        for (Produto p : devolucao.getProdutosDevolver()) {
            p.setValorTotalEmDevolucao(p.getValor() * p.getQuantidadeDevolver());
            valorTotal += (p.getValorTotalEmDevolucao());
        }
        devolucao.setValorDevolucao(valorTotal);
    }

    public Devolucao save(Devolucao devolucao){
        return devolucaoRepository.save(devolucao);
    }
}
