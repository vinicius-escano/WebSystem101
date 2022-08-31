package com.websystem.websystem.service;

import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.model.Produto;
import org.springframework.stereotype.Service;

@Service
public class DevolucaoService {

    public void calculaDevolucao(Devolucao devolucao) {
        double valorTotal = 0.0;
        for (Produto p : devolucao.getProdutosDevolver()) {
            valorTotal += (p.getValor() * p.getQuantidadeDevolver());
        }
        devolucao.setValorDevolucao(valorTotal);
    }
}
