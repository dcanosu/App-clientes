package com.clientes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clientes.model.entities.Moto;
import com.clientes.model.repositories.MotoRepositorio;
import com.clientes.service.MotoService;
// http://blog.hadsonpar.com/2023/01/crud-con-spring-boot-postgresql-y.html
@Service
public class MotoServiceImpl implements MotoService {

    private final MotoRepositorio motoRepositorio;

    public MotoServiceImpl(MotoRepositorio motoRepositorio) {
        this.motoRepositorio = motoRepositorio;
    }

    @Override
    public Moto createMoto(Moto moto){
        return motoRepositorio.save(moto);
    }

    @Override
    public Moto getMotoById(Long id) throws Exception{
        return motoRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontro la moto con id: " + id));
    }

    @Override
    public List<Moto> getAllMotos(){
        return motoRepositorio.findAll();
    }

    @Override
    public List<Moto> getCustomMotos(){
        return motoRepositorio.getAllMotos(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }

    @Override
    public Moto updateMoto(Moto moto) throws Exception{
        if (!motoRepositorio.existsById(moto.getId())) {
            throw new Exception("No se encontró la moto con id: " + moto.getId());
        }
        return motoRepositorio.save(moto);
    }

    @Override
    public void updateCustomMoto(Moto motoData) throws Exception{
        Long id = motoData.getId();
        if (id == null) {
            throw new Exception("El ID de la moto no puede ser null");
        }

        motoRepositorio.findById(id).ifPresentOrElse(motoExistente -> {
            if (motoData.getMarca() != null) {
                motoExistente.setMarca(motoData.getMarca());
            }
            if (motoData.getModelo() != null) {
                motoExistente.setModelo(motoData.getModelo());
            }
            if (motoData.getPlaca() != null) {
                motoExistente.setPlaca(motoData.getPlaca());
            }
            if (motoData.getFk_cliente_id() != null) {
                motoExistente.setFk_cliente_id(motoData.getFk_cliente_id());
            }

            motoRepositorio.save(motoExistente);
        }, () -> {
            throw new RuntimeException("Moto no encontrada con id: " + id);
        });
    }

    @Override
    public void deleteMotoById(Long id) throws Exception{
        getMotoById(id); // lanza excepción si no existe
        motoRepositorio.deleteById(id);
    }

    // @Override
    // public void deleteMotoById(Long id) throws Exception {
    //     motoRepositorio.findById(id).ifPresentOrElse(
    //         moto -> motoRepositorio.deleteById(id),
    //         () -> { throw new RuntimeException("Moto no encontrada con id: " + id); }
    //     );
    // }
}