package com.websystem.websystem.service;

import com.websystem.websystem.enums.VendaStatus;
import com.websystem.websystem.model.Produto;
import com.websystem.websystem.model.Venda;
import com.websystem.websystem.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Venda salvarVenda(Venda venda){
        return vendaRepository.save(venda);
    }

    public Optional<Venda> buscaVenda(Integer codigo){
        Optional<Venda> opVenda = vendaRepository.findById(codigo);
        if(opVenda.isPresent()){
            return opVenda;
        }
        return Optional.empty();
    }

    public void alteraStatusVenda(Venda venda){
        vendaRepository.alteraStatusVenda(venda.getModoPagamento(), venda.getVendaStatus(), venda.getCodigo());
    }


    public List<Venda> buscaPorPeriodo(String dataInicio, String dataFim){
        return vendaRepository.findByPeriodo(dataInicio, dataFim);
    }

}
