public class BecaUniversitaria {
    int tiempo = 0;
    double monto = 0;
    double interes = 0;

    BecaUniversitaria(){
        this.monto = 0;
        this.interes = 0;
        this.tiempo = 0;
    }

    BecaUniversitaria(int pTiempo, double pMonto, double pInteres){
        this.monto = pMonto;
        this.interes = pInteres;
        this.tiempo = pTiempo;
    }

    public double calcularInteresSimple( ){
        double interesSimple = this.monto * this.interes/100 * this.tiempo;
        return interesSimple;
    }

    public double calcularInteresCompuesto( ){
        double interesCompuesto = Math.round(this.monto * (Math.pow((1 + this.interes/100),this.tiempo) - 1));
        return interesCompuesto;
    }

    public String compararInversion ( ){
        double diferencia = this.calcularInteresCompuesto() - this.calcularInteresSimple();
        if(diferencia != 0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
            }
            else{
                return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
            }
        }

    public String compararInversion (int pTiempo, double pMonto, double pInteres){
        this.monto = pMonto;
        this.interes = pInteres;
        this.tiempo = pTiempo;
        return this.compararInversion();
        // double diferencia = this.calcularInteresCompuesto() - this.calcularInteresSimple();
        // if(diferencia != 0){
        //     return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        //     }
        //     else{
        //         return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        //     }
        }

public static void main(String[] args) {
    BecaUniversitaria becaUniversitaria = new BecaUniversitaria(48,10000,2);
    System.out.println(becaUniversitaria.calcularInteresSimple());
    System.out.println(becaUniversitaria.calcularInteresCompuesto());
    System.out.println(becaUniversitaria.compararInversion());
    }
}    