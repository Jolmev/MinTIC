import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class App {
    public static void main(String[] args) throws Exception {
        int numeros[] = {1,2,3,4,5,6,7,8,9,10};
        var archivo = "Numeros.txt";
        var salida = new PrintWriter(archivo);
        for (int i = 0; i<numeros.length; i++){
            salida.print(numeros[i]+";");
        }
        salida.close();

        // Leer la informacion del archivo que creamos

        String nombrearchivo = "Numeros.txt";
        File archivo2 = new File(nombrearchivo);
        if (archivo2.exists()) {
            var lector = new Scanner(archivo2);
            System.out.println( "Números del archivo");
            while (lector.hasNext()) {
                var numeros2 = new StringTokenizer(lector.next(), ",");
                while (numeros2.hasMoreTokens()) {
                    System.out.print(numeros2.nextToken() + "\t");
                }
                System.out.println("");
            }
            lector.close();
        } else {
            System.out.println("¡El fichero no existe!");
        }
    }
}
