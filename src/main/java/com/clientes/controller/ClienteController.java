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

    // Insertar (POST)
    @PostMapping
    public ResponseEntity<Cliente> insertarServicioCliente(@RequestBody Cliente servicioCliente){
        Cliente nuevo = clienteService.insertCliente(servicioCliente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerServicioCliente(@PathVariable Long id){
        try{
            Cliente servicio = clienteService.findCliente(id);
            return ResponseEntity.ok(servicio);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos (GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> listarServicioCliente(){
        return ResponseEntity.ok(clienteService.listCliente());
    }

    // Actualizar (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarServicioCliente(@PathVariable Long id, @RequestBody Cliente servicioCliente) {
        try {
            servicioCliente.setId(id); // Asegura que el ID coincida
            Cliente actualizado = clienteService.updateCliente(servicioCliente);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicioCliente(@PathVariable Long id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todos")
    public List<Cliente> getAllServicios(){
        return clienteService.getAllClientes();
    }
}