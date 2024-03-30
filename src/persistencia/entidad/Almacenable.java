package persistencia.entidad;

// Interfaz que recibe un generico que debería ser la
// propia clase que implementa la interfaz, con el fin
// de poder tener la clase instanciar, esta funcion
// deberá dada la cadena de string separadas por comas
// instanciar un objeto, de forma que podemos manejar
// mejor los repositorios de forma generica
public interface Almacenable <ClaseQueImplementa>{
    String toStringCsv();
    static <ClaseQueImplementa> ClaseQueImplementa instanciarDeCsv(String csvStr){return null;}
}
