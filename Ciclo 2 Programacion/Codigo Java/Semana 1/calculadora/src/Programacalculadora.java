import java.util.Scanner;

class calculadora{
    String color = "gris";
    int digitos = 10;
    double numero1;
    double numero2;
    double resultado;
    private String operacion;

    double sumar()
    {
        this.resultado = this.numero1 + this.numero2;
        return this.resultado;
    }

    double restar()
    {
        this.resultado = this.numero1 - this.numero2;
        return this.resultado;
    }

    double multiplicar()
    {
        this.resultado = this.numero1 * this.numero2;
        return this.resultado;
    }

    double dividir()
    {
        this.resultado = this.numero1 / this.numero2;
        return this.resultado;
    }

    void mostrarResultado()
    {
        System.out.println("El resultado de la operacion de " + this.operacion + " es: " + this.resultado);
    }

    void setOperacion(String operacion)
    {
        this.operacion = operacion;
    }

    String getOperacion()
    {
        return this.operacion;
    }
}

public class Programacalculadora {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenidos a su aplicacion Calculadora");
        
        calculadora nuevaCalculadora = new calculadora();
        Scanner lector = new Scanner(System.in);
        System.out.println("Por favor ingrese un numero: ");
        nuevaCalculadora.numero1 = Double.parseDouble(lector.nextLine());
        System.out.println("Por favor ingrese un segundo numero: ");
        nuevaCalculadora.numero2 = Double.parseDouble(lector.nextLine());
        System.out.println("Por favor ingrese la operacion a realizar (+,-,*,/): ");
        nuevaCalculadora.setOperacion(lector.nextLine());
        String operacion = nuevaCalculadora.getOperacion();

        if(operacion.equals("+"))  // esto se llama condicionales anidados y es mas eficiente
        {
            nuevaCalculadora.sumar();
        }
        else{
            if(operacion.equals("-"))
            {
                nuevaCalculadora.restar();
            }
            else{
                if(operacion.equals("*"))
                {
                    nuevaCalculadora.multiplicar();
                }
                else{
                    if(operacion.equals("/"))
                    {
                        nuevaCalculadora.dividir();
                    }
                    else{
                        System.out.println("La opcion no es valida");
                    }
                }
            }
        }
        // double resultado = nuevaCalculadora.sumar();
        // nuevaCalculadora.mostrarResultado();
        // resultado = nuevaCalculadora.restar();
        // nuevaCalculadora.mostrarResultado();
        // resultado = nuevaCalculadora.multiplicar();
        // nuevaCalculadora.mostrarResultado();
        // resultado = nuevaCalculadora.dividir();
        // nuevaCalculadora.mostrarResultado();
        nuevaCalculadora.mostrarResultado();
        lector.close();    
    }   
}
