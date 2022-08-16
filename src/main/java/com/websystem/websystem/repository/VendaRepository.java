package com.websystem.websystem.repository;

import com.websystem.websystem.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    @Transactional
    default void insertProdutosVendas(int vendaCodigo, int codigoProduto, int quantidadeVenda, EntityManager entityManager){
        entityManager.createNativeQuery("INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO, PRODUTO_CODIGO, PRODUTO_QUANTIDADE) VALUES (?, ?, ?)")
                .setParameter(1, vendaCodigo)
                .setParameter(2, codigoProduto)
                .setParameter(3, quantidadeVenda)
                .executeUpdate();
    }

}
