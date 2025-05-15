package com.clientes.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clientes.model.entities.Cliente;
import com.clientes.model.repositories.ClienteRepositorio;
import com.clientes.service.ClienteService;

@Service
public class ServicioClienteImpl implements ClienteService {
    

    private final ClienteRepositorio clienteRepositorio;

    // @Autowired -> No es recomendable prosionalmente dado que no facilita pruebas mocks
    // clienteRepositorio clienteRepositorio2;

    @Override
    public Cliente insertServicioCliente(Cliente servicioCliente){
        return clienteRepositorio.save(servicioCliente);
    }

    public ServicioClienteImpl(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public Cliente findServicioCliente(Long id) throws Exception{
        return clienteRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontró el id: " + id));
    }

    @Override
    public List<Cliente> listServicioCliente(){
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente updateServicioCliente(Cliente servicioCliente) throws Exception{
        if (!clienteRepositorio.existsById(servicioCliente.getId())) {
            throw new Exception("No se encontró el ID: " + servicioCliente.getId());
        }
        return clienteRepositorio.save(servicioCliente);
    }

    // @Override
    // public ServicioCliente updateServicioCliente(ServicioCliente servicioCliente) throws Exception{
    //     findServicioCliente(servicioCliente.getId());
    //     return clienteRepositorio.save(servicioCliente);
    // }

    public void deleteServicioCliente(Long id) throws Exception{
        findServicioCliente(id); // lanza excepción si no existe
        clienteRepositorio.deleteById(id);
    }

    @Override
    public List<Cliente> getAllServicioClientes(){
        return clienteRepositorio.getAllClientes(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }
}
