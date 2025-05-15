package com.clientes.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clientes.model.entities.Moto;
import com.clientes.model.repositories.MotoRepositorio;
import com.clientes.service.MotoService;

// http://blog.hadsonpar.com/2023/01/crud-con-spring-boot-postgresql-y.html
@Service
public class ServicioMotoImpl implements MotoService {

    private final MotoRepositorio servicioMotoRepositorio;

    public ServicioMotoImpl(MotoRepositorio servicioMotoRepositorio) {
        this.servicioMotoRepositorio = servicioMotoRepositorio;
    }

    // @Autowired -> No es recomendable prosionalmente dado que no facilita pruebas mocks
    // ServicioMotoRepositorio servicioMotoRepositorio2;

    @Override
    public Moto insertServicioMoto(Moto servicioMoto){
        return servicioMotoRepositorio.save(servicioMoto);
    }

    @Override
    public Moto findServicioMoto(Long id) throws Exception{
        return servicioMotoRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontro el id: " + id));
    }

    @Override
    public List<Moto> listServicioMoto(){
        return servicioMotoRepositorio.findAll();
    }

    @Override
    public Moto updateServicioMoto(Moto servicioMoto) throws Exception{
        if (!servicioMotoRepositorio.existsById(servicioMoto.getId())) {
            throw new Exception("No se encontró el ID: " + servicioMoto.getId());
        }
        return servicioMotoRepositorio.save(servicioMoto);
    }

    // @Override
    // public ServicioMoto updateServicioMoto(ServicioMoto servicioMoto) throws Exception{
    //     findServicioMoto(servicioMoto.getId());
    //     return servicioMotoRepositorio.save(servicioMoto);
    // }

    public void deleteServicioMoto(Long id) throws Exception{
        findServicioMoto(id); // lanza excepción si no existe
        servicioMotoRepositorio.deleteById(id);
    }

    @Override
    public List<Moto> getAllServicioMotos(){
        return servicioMotoRepositorio.getAllMotos(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }
}
