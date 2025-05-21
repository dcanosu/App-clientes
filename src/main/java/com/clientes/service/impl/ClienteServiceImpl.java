package com.clientes.service.impl;

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
    public Cliente createCliente(Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente getClienteById(Long id) throws Exception{
        return clienteRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontró el cliente con id: " + id));
    }

    @Override
    public List<Cliente> getAllClientes(){
        return clienteRepositorio.findAll();
    }

    @Override
    public List<Cliente> getCustomClientes(){
        return clienteRepositorio.getAllClientes(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) throws Exception{
        if (!clienteRepositorio.existsById(cliente.getId())) {
            throw new Exception("No se encontró el cliente con id: " + cliente.getId());
        }
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void updateCustomCliente(Cliente clienteData) throws Exception{
        Long id = clienteData.getId();
        if (id == null) {
            throw new Exception("El ID del cliente no puede ser null");
        }

        clienteRepositorio.findById(id).ifPresentOrElse(clienteExistente -> {
            if (clienteData.getNombre() != null) {
                clienteExistente.setNombre(clienteData.getNombre());
            }
            if (clienteData.getApellido() != null) {
                clienteExistente.setApellido(clienteData.getApellido());
            }
            if (clienteData.getTelefono() != null) {
                clienteExistente.setTelefono(clienteData.getTelefono());
            }
            if (clienteData.getEmail() != null) {
                clienteExistente.setEmail(clienteData.getEmail());
            }

            clienteRepositorio.save(clienteExistente);
        }, () -> {
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        });
    }

    @Override
    public void deleteCliente(Long id) throws Exception{
        getClienteById(id); // lanza excepción si no existe
        clienteRepositorio.deleteById(id);
    }
}