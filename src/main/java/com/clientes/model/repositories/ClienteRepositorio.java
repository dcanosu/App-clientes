package com.clientes.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clientes.model.entities.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    List<Cliente> getAllClientes();
}