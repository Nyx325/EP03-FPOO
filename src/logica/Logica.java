package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Cliente;
import persistencia.repositorio.Repositorio;

public abstract class Logica{
    public Repositorio<Cliente> repo;

    public List<Cliente> buscar(String nombre, String apellidos){
        List<Cliente> busqueda = new ArrayList<>();

        for(Cliente reg:repo.getLista()){
            if(reg.nombre == nombre && reg.apellidos == apellidos){
                busqueda.add(reg);
            }
        }

        return busqueda;
    }

    public void agregar(Cliente nuevo) throws IOException{
        for(Cliente reg:repo.getLista()){
            if(reg.equals(nuevo)){
                System.out.println("Usuario existe");
                return;
            }

            if(reg.email.equals(nuevo.email)){
                System.out.println("Otro usuario ya cuenta con ese email");
                return;
            }

            if(reg.telefono.equals(nuevo.telefono)){
                System.out.println("Otro usuario ya con ese telefono");
                return;
            }

            repo.add(nuevo);
            repo.guardar();
        }
    }

    public abstract List<Cliente> buscar(String campo);
}
