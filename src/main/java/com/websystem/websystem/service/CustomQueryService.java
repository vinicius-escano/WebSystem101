package com.websystem.websystem.service;

import com.websystem.websystem.model.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CustomQueryService {
    @PersistenceContext
    private EntityManager entityManager;

    List<Integer> buscaItens(int codigoPedido) {
        return entityManager.createNativeQuery("SELECT PRODUTO_CODIGO FROM TB_PRODUTOS_PEDIDOS_COMPRAS WHERE PEDIDO_COMPRA_CODIGO = "+ codigoPedido).getResultList();
    }

}
