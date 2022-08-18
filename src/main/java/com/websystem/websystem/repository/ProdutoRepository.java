package com.websystem.websystem.repository;

import com.websystem.websystem.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE CODIGO IN :codigos")
    List<Produto> listByReference(@Param("codigos") List<Integer> codigos);

}
