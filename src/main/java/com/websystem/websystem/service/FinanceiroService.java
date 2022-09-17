package com.websystem.websystem.service;

import com.websystem.websystem.dto.DevolucaoDepositoBancarioDTO;
import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.repository.CustomQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FinanceiroService {

    @Autowired
    private CustomQueryRepository customQueryRepository;

    @Autowired
    private DevolucaoService devolucaoService;

    public List<Devolucao> buscaDevolucaoDepositoBancarioEmAberto(){
        List<DevolucaoDepositoBancarioDTO> listDevolucoes = customQueryRepository.buscaDevolucaoDepositoBancarioPendente();
        List<Devolucao> listDevolucoesPendentes = new ArrayList<>();
        listDevolucoes.stream().forEach(i -> {
            Optional<Devolucao> opDevolucao = devolucaoService.findById(i.getDevolucaoCodigo());
            if(opDevolucao.isPresent()){
                listDevolucoesPendentes.add(opDevolucao.get());
            }
        });
        return listDevolucoesPendentes;
    }
}
