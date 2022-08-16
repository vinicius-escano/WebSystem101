package com.websystem.websystem.repository;

import com.websystem.websystem.model.PedidoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, Integer> {

    @Transactional
    default void insert(int pedidoCompraCodigo, int produtoCodigo, EntityManager entityManager){
        entityManager.createNativeQuery("INSERT INTO TB_PRODUTOS_PEDIDOS_COMPRAS (PEDIDO_COMPRA_CODIGO, PRODUTO_CODIGO) VALUES (?, ?)")
                .setParameter(1, pedidoCompraCodigo)
                .setParameter(2, produtoCodigo)
                .executeUpdate();
    }

}
