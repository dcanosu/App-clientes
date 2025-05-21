package com.clientes.service;

import java.util.List;

import com.clientes.model.entities.Moto;

public interface MotoService {
    
    Moto createMoto(Moto moto);

    Moto getMotoById(Long id) throws Exception;

    List<Moto> getAllMotos();

    List<Moto>getCustomMotos();

    Moto updateMoto(Moto moto) throws Exception;

    void updateCustomMoto(Moto motoData) throws Exception;

    void deleteMotoById(Long id) throws Exception;
}