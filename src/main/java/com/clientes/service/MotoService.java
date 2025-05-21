package com.clientes.service;

import java.util.List;

import com.clientes.model.entities.Moto;

public interface MotoService {
    
    public Moto insertMoto(Moto servicioMoto);

    public Moto findMoto(Long id) throws Exception;

    public List<Moto> listMoto();

    public Moto updateMoto(Moto servicioMoto) throws Exception;

    public void deleteMoto(Long id) throws Exception;

    public List<Moto>getAllMotos();
}