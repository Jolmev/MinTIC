import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        // var nombrearchivo = "Objetos.dat";
        // try {
        //     var archivo = new FileOutputStream(nombrearchivo);
        //     var oos = new ObjectOutputStream(archivo);
        //     oos.writeObject(new Persona("552871883","María", "Ruiz Ramos"));
        //     oos.writeObject(new Persona("403020104","Juan", "González López"));
        //     oos.close();
        // } catch (FileNotFoundException e) {
        // System.out.println("¡El fichero no existe!");
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // };

        var nombre = "Objetos.dat";
        try {
            var archivo = new FileOutputStream(nombre);
            var oos = new ObjectOutputStream(archivo);
            oos.writeObject(new Persona("552871883","María", "Ruiz Ramos"));
            oos.writeObject(new Persona("403020104","Juan", "González López"));
            oos.close();
        } catch (FileNotFoundException e) {
        System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
        System.out.println(e.getMessage());
        } catch (Exception e) {
        System.out.println(e.getMessage());
        };

        // Leemos el archivo que contiene los datos de los objetos de la clase persona

        var nombrearchivo1 = "Objetos.dat";
        try {
            var archivo = new FileInputStream(nombrearchivo1);
            var ois = new ObjectInputStream(archivo);
            var persona1 = (Persona) ois.readObject();
            var persona2 = (Persona) ois.readObject();
            ois.close();
            System.out.println("Cedula\t Nombre");
            System.out.println(persona1.getAtributos());
            System.out.println(persona2.getAtributos());
        } catch (FileNotFoundException e) {
        System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
        System.out.println(e.getMessage());
        } catch (Exception e) {
        System.out.println(e.getMessage());
        };

       

    }
}
