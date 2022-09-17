package com.websystem.websystem.service;

import com.websystem.websystem.model.Banco;
import com.websystem.websystem.model.Cliente;
import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.repository.BancoRepository;
import com.websystem.websystem.repository.CustomQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BancoService {

    @Autowired
    BancoRepository bancoRepository;

    @Autowired
    CustomQueryRepository customQueryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Banco> findAll(){
        return bancoRepository.findAll();
    }

    public Optional<Banco> findById(int codigo){
        return bancoRepository.findById(codigo);
    }

}
