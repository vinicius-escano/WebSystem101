package com.websystem.websystem.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.websystem.websystem.dto.ProdutoVendaDTO;
import com.websystem.websystem.dto.QProdutoVendaDTO;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class CustomQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    List<Integer> buscaItensFromProdutosPedidosCompras(int codigoPedido) {
        return entityManager.createNativeQuery("SELECT PRODUTO_CODIGO FROM TB_PRODUTOS_PEDIDOS_COMPRAS WHERE PEDIDO_COMPRA_CODIGO = "+ codigoPedido).getResultList();
    }

    List<ProdutoVendaDTO> buscaItensFromVendas(int codigoVenda) {
        Query query = entityManager.createNativeQuery("SELECT CODIGO, VENDA_CODIGO, PRODUTO_CODIGO, PRODUTO_QUANTIDADE, PRODUTO_VALOR_TOTAL FROM TB_PRODUTOS_VENDAS WHERE VENDA_CODIGO = " + codigoVenda, "ProdutoDTOResults");
        List<ProdutoVendaDTO> listProdutos = (List<ProdutoVendaDTO>) query.getResultList();
        return listProdutos;
    }

}
