package com.websystem.websystem.service;

import com.websystem.websystem.model.Cliente;
import com.websystem.websystem.repository.ClienteRepository;
import com.websystem.websystem.repository.ContatoRepository;
import com.websystem.websystem.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ContatoRepository contatoRepository;

    public List<Cliente> getAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Integer codigo){
        Optional<Cliente> opCliente = clienteRepository.findById(codigo);
        if(opCliente.isPresent()){
            opCliente.get().setListEnderecos(enderecoRepository.findAllByClientes(codigo));
            opCliente.get().setListContatos(contatoRepository.findAllByClientes(codigo));
            return opCliente;
        }
        return Optional.empty();
    }



}
