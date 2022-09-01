package com.websystem.websystem.repository;

import com.websystem.websystem.model.Devolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DevolucaoRepository extends JpaRepository<Devolucao, Integer> {

}
