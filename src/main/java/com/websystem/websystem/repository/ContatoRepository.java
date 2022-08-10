package com.websystem.websystem.repository;

import com.websystem.websystem.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contatos, Integer> {

}
