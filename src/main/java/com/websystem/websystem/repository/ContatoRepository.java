package com.websystem.websystem.repository;

import com.websystem.websystem.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contatos, Integer> {

    @Query("SELECT new Contatos(codigo,numeroTelefone,email,cliente) FROM Contatos WHERE cliente_id = ?1")
    List<Contatos> findAllByClientes(Integer id);
}
