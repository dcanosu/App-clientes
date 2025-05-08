package com.clientes.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clientes.model.entities.Moto;

@Repository
public interface MotoRepositorio extends JpaRepository<Moto, Long>{
    @Query(value = "SELECT * FROM motos", nativeQuery = true)
    List<Moto> getAllMotos();
}
