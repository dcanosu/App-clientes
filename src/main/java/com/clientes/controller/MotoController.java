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

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    // Crear una moto (POST)
    @PostMapping
    public ResponseEntity<Moto> crearMoto(@RequestBody Moto moto){
        Moto nuevo = motoService.createMoto(moto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar una moto por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMotoPorId(@PathVariable Long id){
        try{
            Moto moto = motoService.getMotoById(id);
            return ResponseEntity.ok(moto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todas las motos (GET)
    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos(){
        return ResponseEntity.ok(motoService.getAllMotos());
    }

    // Listar todas las motos personalizado (GET)
    @GetMapping("/todos")
    public List<Moto> listarMotosPersonalizado(){
        return motoService.getCustomMotos();
    }

    // Actualizar una moto (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Moto> actualizarMoto(@PathVariable Long id, @RequestBody Moto moto) {
        try {
            moto.setId(id); // Asegura que el ID coincida
            Moto motoActualizada = motoService.updateMoto(moto);
            return ResponseEntity.ok(motoActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarMotoPersonalizado(@RequestBody Moto moto) {
        try {
            motoService.updateMoto(moto);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 si no la encuentra
        }
    }

    // Eliminar una moto (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMoto(@PathVariable Long id) {
        try {
            motoService.deleteMotoById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}