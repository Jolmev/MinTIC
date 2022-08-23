class Vehiculo{
    String  placa = ""; // Siempre que declaramos una variable en java debemos especificar que tipo de variable es
    int num_llantas = 4;
    int cilindraje = 1000;
    int pasajeros = 5;
    private String num_serie; // private vuelve privado un atributo
    double capacidad_tanque = 20; // en java el codigo se comenta con doble slash (capacidad del tanque en litros)

    public Vehiculo(String placa, int cilindraje, int pasajeros, String num_serie){ // metodo constructor, no lleva void
        this.placa = placa; // this es lo mismo que el self en python
        this.cilindraje = cilindraje; // los de la izquierda son los nombres de los atributos de mas arriba
        this.pasajeros = pasajeros; // los de la derecha no importan y son los que estan entre el parentesis de Vehiculo
        this.num_serie = num_serie;
    }

    void avanzar(float velocidad) { // void = no retorna nada
        System.out.println("El vehiculo con placa " + this.placa + " esta avanzando a " + velocidad + " km/h");
    }

    void frenar(){
        System.out.println("El vehiculo se detuvo");
    }

    // int indica que el metodo va a retornar un valor entero (el numero de llantas del vehiculo)
    int get_num_llantas(){
        return this.num_llantas;
    }

    int get_num_ocupantes(){
        return this.pasajeros + 1;
    }

    double get_capacidad_litros(){
        return this.capacidad_tanque;
    }

    // double es un tipo de dato que almacena numeros reales (con coma flotante) con muchos mas decimales que float
    double get_capacidad_galones(){
        return this.capacidad_tanque*0.264172;
    }

    @Override 
    public String toString(){ // poner algo que este en private en el return de esto hace que si se pueda imprimir
        return "Placa: " + this.placa + "\nNúmero de llantas: " + this.num_llantas + "\nCilindraje: " + this.cilindraje + "\nPasajeros: " + this.pasajeros + "\nNumero de serie: " + this.num_serie + "\nCapacidad del tanque: " + this.capacidad_tanque;
    }

    void set_capacidad_litros(float capacidad){
        this.capacidad_tanque = capacidad;
    }

    void set_capacidad_galones(float capacidadgalones){
        this.capacidad_tanque = capacidadgalones/0.264172;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        
        Vehiculo micarrito = new Vehiculo("ABC123",13000,2,"R41343244FEW"); // Estamos instanciando la clase vehiculo, es decir, creando un objeto de la clase vehiculo
        micarrito.avanzar(30);
        micarrito.frenar();
        // System.out.println("El numero de llantas de micarrito es: " + micarrito.get_num_llantas());
        // System.out.println("La capacidad del tanque de micarrito en litros es: " + micarrito.get_capacidad_litros());
        // System.out.println("La capacidad del tanque de micarrito en galones es: " + micarrito.get_capacidad_galones());
        System.out.println(micarrito.toString()); // toString hace una representacion en texto de todo el objeto

        Vehiculo milancha = new Vehiculo("FFD876",2000,6,"EUYNDNVMDD");
        System.out.println(milancha.toString());
    }
}
