package com.clientes.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clientes.model.entities.Moto;
import com.clientes.model.repositories.MotoRepositorio;
import com.clientes.service.MotoService;

// http://blog.hadsonpar.com/2023/01/crud-con-spring-boot-postgresql-y.html
@Service
public class MotoServiceImpl implements MotoService {

    private final MotoRepositorio servicioMotoRepositorio;

    public MotoServiceImpl(MotoRepositorio servicioMotoRepositorio) {
        this.servicioMotoRepositorio = servicioMotoRepositorio;
    }

    @Override
    public Moto insertMoto(Moto moto){
        return servicioMotoRepositorio.save(moto);
    }

    @Override
    public Moto findMoto(Long id) throws Exception{
        return servicioMotoRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontro el id: " + id));
    }

    @Override
    public List<Moto> listMoto(){
        return servicioMotoRepositorio.findAll();
    }

    @Override
    public List<Moto> getAllMotos(){
        return servicioMotoRepositorio.getAllMotos(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }

    @Override
    public Moto updateMoto(Moto moto) throws Exception{
        if (!servicioMotoRepositorio.existsById(moto.getId())) {
            throw new Exception("No se encontró la moto ID: " + moto.getId());
        }
        return servicioMotoRepositorio.save(moto);
    }

    @Override
    public void deleteMoto(Long id) throws Exception{
        findMoto(id); // lanza excepción si no existe
        servicioMotoRepositorio.deleteById(id);
    }
}