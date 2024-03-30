package persistencia.entidad;

public class Empleado implements Almacenable<Empleado> {
    public String nombre = "";
    public String apellidos = "";
    public String telefono = "";
    public String email = "";
    public String departamento = "";
    public String cargo = "";

    public Empleado(){}

    public Empleado(String nombre, String apellidos, String telefono, String email, String departamento, String cargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.departamento = departamento;
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return nombre+","+apellidos+","+telefono+","+email+" "+departamento+" "+cargo+"\n";
    }

    @Override
    public String toStringCsv(){
        return nombre+";"+apellidos+";"+telefono+";"+email+";"+departamento+";"+cargo+"\n";
    }

    public Empleado instanciaDeCsv(String csvStr) {
        String[] splitStr = csvStr.split(",");
        Empleado e = new Empleado(
            splitStr[0],
            splitStr[1],
            splitStr[2],
            splitStr[3],
            splitStr[4],
            splitStr[5]
        );
        return e;
    }

    /** Funcion que determina a nivel de valor si dos objetos
     * empleado tienen los mismos valores en sus atributos */
    public boolean equals(Empleado e){
        if(
            e.equals(this) &&
            e.departamento.equals(this.departamento) &&
            e.cargo.equals(this.cargo)
        )
            return true;
        else
            return false;
    }


}
