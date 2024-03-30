package persistencia.entidad;

public class Cliente implements Almacenable<Cliente> {
    public String nombre = "";
    public String apellidos = "";
    public String telefono = "";
    public String email = "";

    public Cliente(){}

    public Cliente(String nombre, String apellidos, String telefono, String email){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public String toStringCsv(){
        return nombre+","+apellidos+","+telefono+","+email+"\n";
    }

    public Cliente instanciaDeCsv(String csvStr){
        String[] splitStr = csvStr.split(",");
        Cliente c = new Cliente(
            splitStr[0],
            splitStr[1],
            splitStr[2],
            splitStr[3]
        );
        return c;
    }

    /** Funcion que determina a nivel de valor si dos objetos
     * cliente tienen los mismos valores en sus atributos de
     * forma algo cutre */
    public boolean equals(Cliente c){
        if(
            c.nombre.equals(this.nombre) &&
            c.apellidos.equals(this.apellidos) &&
            c.telefono.equals(this.telefono) &&
            c.email.equals(this.email)
        )
            return true;
        else
            return false;
    }
}
