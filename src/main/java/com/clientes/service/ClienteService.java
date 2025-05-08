package com.clientes.service;

import java.util.List;

import com.clientes.model.entities.Cliente;

public interface ClienteService {
    public Cliente insertServicioCliente(Cliente servicioCliente);

    public Cliente findServicioCliente(Long id) throws Exception;

    public List<Cliente> listServicioCliente();

    public Cliente updateServicioCliente(Cliente servicioCliente) throws Exception;

    public void deleteServicioCliente(Long id) throws Exception;

    public List<Cliente>getAllServicioClientes();
}
