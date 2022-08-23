class Persona{
    private String nombre;
    private String apellido;
    private String identificacion;
    String correo;

    Persona(String nombre, String apellido, String identificacion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
    }

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    void setApellido(String apellido){
        this.apellido = apellido;
    }

    String getNombre(){
        return this.nombre;
    }

    String getApellido(){
        return this.apellido;
    }

    void ingresar(){
    }

    void prestarLibro(){
    }
}

class Profesor extends Persona{
    String codigo;
    String oficina;
    String facultad;
    String materia;

    Profesor(String nombre, String apellido, String identificacion, String codigo, String facultad, String materia){
        super(nombre,apellido,identificacion);
        this.codigo = codigo;
        this.facultad = facultad;
        this.materia = materia;
    }

    void registrarNotas(){

    }

    void consultarNotas(){

    }

    void cancelarGrupo(){

    }

    void setOficina(String oficina){
        this.oficina = oficina;
    }
}

class Estudiante extends Persona{
    String codigo;
    double promedio;
    String carrera;

    Estudiante(String nombre, String apellido, String identificacion, String codigo, String carrera){
        super(nombre, apellido, identificacion);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    void presentarExamen(){

    }

    void consultarNotas(){

    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenidos al sistema de la universidad");

        Profesor miprofe = new Profesor("Felipe", "Diaz", "A1234", "UTP123", "Medicina", "Proyectos");
        miprofe.ingresar();
        miprofe.prestarLibro();
        miprofe.registrarNotas();
        miprofe.cancelarGrupo();
        miprofe.setOficina("B12");
    
        Estudiante estudiante1 = new Estudiante("Juan","Lopez","343234","UTPXCE34","Ingenieria industrial");
        estudiante1.ingresar();
        estudiante1.prestarLibro();
        estudiante1.presentarExamen();
        estudiante1.consultarNotas();
    }
}
