package com.websystem.websystem.service;

import org.springframework.stereotype.Service;
import com.websystem.websystem.repository.ClienteRepository;
import com.websystem.websystem.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Integer codigo){
        Optional<Cliente> opCliente = clienteRepository.findById(codigo);
        if(opCliente.isPresent()){
            return opCliente;
        }
        return Optional.empty();
    }


}
