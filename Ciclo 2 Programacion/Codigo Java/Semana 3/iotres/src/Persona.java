import java.io.Serializable;

public class Persona implements Serializable {
    private String cedula;
    private String nombre;
    private String apellidos;
    public Persona(String cedula, String nombre,
    String apellidos) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.apellidos = apellidos;
    }
    public String getcedula() {
    return this.cedula;
    }
    public String getNombre() {
    return this.nombre;
    }
    public String getApellidos() {
    return this.apellidos;
    }
    public String getAtributos() {
    return this.getcedula() + " "
    + this.getApellidos() + ", "
    + this.getNombre();
    }
}