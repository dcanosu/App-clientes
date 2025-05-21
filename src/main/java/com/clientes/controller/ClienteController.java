package com.clientes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.model.entities.Cliente;
import com.clientes.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Crear un cliente (POST)
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente nuevo = clienteService.createCliente(cliente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar un cliente por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
        try{
            Cliente cliente = clienteService.getClienteById(id);
            return ResponseEntity.ok(cliente);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos los clientes (GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    // Listar todos los clientes personalizado (GET)
    @GetMapping("/todos")
    public List<Cliente> listarClientesPersonalizado(){
        return clienteService.getCustomClientes();
    }

    // Actualizar cliente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            cliente.setId(id); // Asegura que el ID coincida
            Cliente clienteActualizado = clienteService.updateCliente(cliente);
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarClientePersonalizado(@RequestBody Cliente cliente) {
        try {
            clienteService.updateCliente(cliente);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 si no la encuentra
        }
    }

    // Eliminar un cliente (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}