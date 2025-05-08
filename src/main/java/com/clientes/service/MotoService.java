package com.clientes.service;

import java.util.List;

import com.clientes.model.entities.Moto;

public interface MotoService {
    
    public Moto insertServicioMoto(Moto servicioMoto);

    public Moto findServicioMoto(Long id) throws Exception;

    public List<Moto> listServicioMoto();

    public Moto updateServicioMoto(Moto servicioMoto) throws Exception;

    public void deleteServicioMoto(Long id) throws Exception;

    public List<Moto>getAllServicioMotos();
}
