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

import com.clientes.model.entities.Moto;
import com.clientes.service.MotoService;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    private final MotoService servicioMotoService;

    public MotoController(MotoService servicioMotoService) {
        this.servicioMotoService = servicioMotoService;
    }

    // Insertar (POST)
    @PostMapping
    public ResponseEntity<Moto> insertarServicioMoto(@RequestBody Moto servicioMoto){
        Moto nuevo = servicioMotoService.insertServicioMoto(servicioMoto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerServicioMoto(@PathVariable Long id){
        try{
            Moto servicio = servicioMotoService.findServicioMoto(id);
            return ResponseEntity.ok(servicio);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos (GET)
    @GetMapping
    public ResponseEntity<List<Moto>> listarServicioMoto(){
        return ResponseEntity.ok(servicioMotoService.listServicioMoto());
    }

    // Actualizar (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Moto> actualizarServicioMoto(@PathVariable Long id, @RequestBody Moto servicioMoto) {
        try {
            servicioMoto.setId(id); // Asegura que el ID coincida
            Moto actualizado = servicioMotoService.updateServicioMoto(servicioMoto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicioMoto(@PathVariable Long id) {
        try {
            servicioMotoService.deleteServicioMoto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todos")
    public List<Moto> getAllServicios(){
        return servicioMotoService.getAllServicioMotos();
    }
}