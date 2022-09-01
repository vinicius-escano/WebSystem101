package com.websystem.websystem.repository;

import com.websystem.websystem.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNome(String nome);

    Optional<Cliente> findById(Integer id);

    @Modifying
    @Query("UPDATE Cliente c SET c.creditoEmConta = c.creditoEmConta + ?1 WHERE c.codigo = ?2")
    int insereCreditoEmConta(double valor, int codigo);

}
