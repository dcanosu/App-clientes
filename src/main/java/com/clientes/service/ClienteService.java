package com.clientes.service;

import java.util.List;

import com.clientes.model.entities.Cliente;

public interface ClienteService {
    
    public Cliente insertCliente(Cliente servicioCliente);

    public Cliente findCliente(Long id) throws Exception;

    public List<Cliente> listCliente();

    public Cliente updateCliente(Cliente servicioCliente) throws Exception;

    public void deleteCliente(Long id) throws Exception;

    public List<Cliente>getAllClientes();
}