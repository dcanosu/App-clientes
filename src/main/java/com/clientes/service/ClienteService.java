package com.clientes.service;

import java.util.List;

import com.clientes.model.entities.Cliente;

public interface ClienteService {
    
    Cliente createCliente(Cliente cliente);

    Cliente getClienteById(Long id) throws Exception;

    List<Cliente> getAllClientes();

    List<Cliente>getCustomClientes();

    Cliente updateCliente(Cliente cliente) throws Exception;

    void updateCustomCliente(Cliente clinteData) throws Exception;

    void deleteCliente(Long id) throws Exception;
}