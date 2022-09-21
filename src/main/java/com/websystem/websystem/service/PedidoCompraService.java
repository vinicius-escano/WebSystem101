package com.websystem.websystem.service;

import com.websystem.websystem.enums.StatusAprovacao;
import com.websystem.websystem.model.PedidoCompra;
import com.websystem.websystem.repository.PedidoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoCompraService {

    @Autowired
    private PedidoCompraRepository pedidoCompraRepository;

    @Autowired
    EntityManager entityManager;

    public PedidoCompra save(PedidoCompra pedidoCompra){
        return pedidoCompraRepository.save(pedidoCompra);
    }

    public void insertReferences(int pedidoCodigo, int produtoCodigo){
        pedidoCompraRepository.insert(pedidoCodigo,produtoCodigo,entityManager);
    }

    public Optional<PedidoCompra> findById(int codigo){
        Optional<PedidoCompra> opPedidoCompra = pedidoCompraRepository.findById(codigo);
        if(opPedidoCompra.isPresent()){
            return opPedidoCompra;
        }
        return Optional.empty();
    }

    public List<PedidoCompra> findAll(){
        return pedidoCompraRepository.findAll();
    }

    public List<PedidoCompra> findAllEmAberto(){
        return pedidoCompraRepository.findAllEmAberto(StatusAprovacao.EM_ABERTO);
    }

    public void aprovaPedido(PedidoCompra pedidoCompra, boolean isAprovado){
        if(isAprovado){
            pedidoCompra.setStatus(StatusAprovacao.APROVADO);
        } else {
            pedidoCompra.setStatus(StatusAprovacao.REPROVADO);
        }
       pedidoCompraRepository.saveAndFlush(pedidoCompra);
    }

}
