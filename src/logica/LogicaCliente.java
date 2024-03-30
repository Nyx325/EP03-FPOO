package logica;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import persistencia.entidad.Cliente;
import persistencia.repositorio.Repositorio;

public class LogicaCliente extends Logica {
    public LogicaCliente() throws IOException {
        this.repo = new Repositorio<>("Cliente.csv");
    }

    public List<Cliente> buscar(String email){
        List<Cliente> resultBusq = new ArrayList<>();

        for(Cliente c:repo.getLista()){
            if(c.email.equals(email)){
                resultBusq.add(c);
            }
        }

        return resultBusq;
    }
}
