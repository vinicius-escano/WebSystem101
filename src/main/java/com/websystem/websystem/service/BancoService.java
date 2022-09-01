package com.websystem.websystem.service;

import com.websystem.websystem.model.Banco;
import com.websystem.websystem.model.Cliente;
import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.repository.BancoRepository;
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
    CustomQueryService customQueryService;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Banco> findAll(){
        return bancoRepository.findAll();
    }

    public Optional<Banco> findById(int codigo){
        return bancoRepository.findById(codigo);
    }

    public boolean registraDevolucaoPorDeposito(Cliente cliente, Banco banco, Devolucao devolucao, int agencia, int conta){
        Query query = entityManager.createNativeQuery("INSERT INTO TB_DEVOLUCOES_DEPOSITO_BANCARIO (CLIENTE_CODIGO, DEVOLUCAO_CODIGO, BANCO_CODIGO, AGENCIA_NUMERO, CONTA_NUMERO) VALUES (" + cliente.getCodigo() + "," + devolucao.getCodigo() + "," + banco.getCodigo() + "," + agencia + "," + conta + ")");
        if(query.executeUpdate() > 0){
            return true;
        }
        return false;
    }

}
