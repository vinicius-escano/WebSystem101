package com.websystem.websystem.repository;

import com.querydsl.core.annotations.QueryEmbeddable;
import com.websystem.websystem.enums.ModoPagamento;
import com.websystem.websystem.enums.VendaStatus;
import com.websystem.websystem.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    @Transactional
    default void insertProdutosVendas(int vendaCodigo, int codigoProduto, int quantidadeVenda, EntityManager entityManager) {
        entityManager.createNativeQuery("INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO, PRODUTO_CODIGO, PRODUTO_QUANTIDADE) VALUES (?, ?, ?)")
                .setParameter(1, vendaCodigo)
                .setParameter(2, codigoProduto)
                .setParameter(3, quantidadeVenda)
                .executeUpdate();
    }

    @Modifying
    @Transactional
    @Query("UPDATE Venda v SET v.modoPagamento = ?1, v.vendaStatus = ?2 WHERE v.codigo = ?3")
    void alteraStatusVenda(ModoPagamento modoPagamento, VendaStatus status, Integer codigo);

    @Query("SELECT v from Venda v WHERE v.cadastrado BETWEEN ?1 AND ?2")
    List<Venda> findByPeriodo(String dataInicio, String dataFim);

}
