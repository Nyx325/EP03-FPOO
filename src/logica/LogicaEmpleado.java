package logica;

import java.io.IOException;

import persistencia.entidad.Empleado;
import persistencia.repositorio.Repositorio;

public class LogicaEmpleado extends Logica{
    public LogicaEmpleado() throws IOException {
        repo = new Repositorio<Empleado>();
    }

    public List<Almacenable> buscar(String departamento){
        List<Almacenable> resultBusq = new ArrayList<>();

        for(Almacenable e:repo.getLista()){
            Empleado busqueda = (Empleado) e;
            if(busqueda.getDepartamento().equals(busqueda.getDepartamento())){
                resultBusq.add(e);
            }
        }

        return resultBusq;
    }
}
