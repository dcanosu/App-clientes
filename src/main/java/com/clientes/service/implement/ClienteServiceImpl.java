package com.clientes.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clientes.model.entities.Cliente;
import com.clientes.model.repositories.ClienteRepositorio;
import com.clientes.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    private final ClienteRepositorio clienteRepositorio;
    
    public ClienteServiceImpl(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public Cliente insertCliente(Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente findCliente(Long id) throws Exception{
        return clienteRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontró el cliente con id: " + id));
    }

    @Override
    public List<Cliente> listCliente(){
        return clienteRepositorio.findAll();
    }

        @Override
    public List<Cliente> getAllClientes(){
        return clienteRepositorio.getAllClientes(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) throws Exception{
        if (!clienteRepositorio.existsById(cliente.getId())) {
            throw new Exception("No se encontró el ID: " + cliente.getId());
        }
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) throws Exception{
        findCliente(id); // lanza excepción si no existe
        clienteRepositorio.deleteById(id);
    }
}