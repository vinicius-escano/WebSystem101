package com.websystem.websystem.service;

import com.websystem.websystem.model.Banco;
import com.websystem.websystem.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    @Autowired
    BancoRepository bancoRepository;

    public List<Banco> findAll(){
        return bancoRepository.findAll();
    }
}
