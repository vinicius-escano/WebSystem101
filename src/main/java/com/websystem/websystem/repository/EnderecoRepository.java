package com.websystem.websystem.repository;

import com.websystem.websystem.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT new Endereco(codigo,logradouro,bairro,uf,numero,cidade,cep,cliente) FROM Endereco WHERE cliente_id = ?1")
    List<Endereco> findAllByClientes(Integer id);

}
