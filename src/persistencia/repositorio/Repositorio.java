package persistencia.repositorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Almacenable;

// Crear un generico que debe tener la interfaz almacenable
public class Repositorio<T extends Almacenable<T>>{
    List<T> lista;
    String pathArchivo;

    public Repositorio(String pathArchivo) throws IOException{
        this.pathArchivo = pathArchivo;
        lista = new ArrayList<>();
        File archivo = new File(pathArchivo);
        List<String> registros = Files.readAllLines(archivo.toPath());
        
        for(String registro:registros){
            lista.add(Almacenable.instanciarDeCsv(registro));
        }
    }

    public void guardar() throws IOException{
        File archivo = new File(pathArchivo);
        FileWriter fwriter = new FileWriter(archivo);
        PrintWriter pwriter = new PrintWriter(fwriter);

        for(T registro:lista){
            String csvStr = registro.toStringCsv();
            pwriter.append(csvStr);
        }
        pwriter.close();
        fwriter.close();
    }

    public List<T> getLista(){
        return lista;
    }

    public void add(T registro){
        lista.add(registro);
    }

    public void remove(int index){
        lista.remove(index);
    }
}
