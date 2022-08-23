package view;

import java.sql.ResultSet;

import controller.ReportesController;

public class ReportesView {
    ReportesController controlador = new ReportesController();

    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }
    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s","ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            
            try{
            ResultSet Proyectos = controlador.generarInformeProyectosBanco(banco);
            while(Proyectos.next()){
                int id = Proyectos.getInt("ID_Proyecto");
                String constructora = Proyectos.getString("Constructora");
                String ciudad = Proyectos.getString("Ciudad");
                String clasificacion = Proyectos.getString("Clasificacion");
                int estrato = Proyectos.getInt("Estrato");
                String lider = Proyectos.getString("LIDER");
                System.out.println(String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad, clasificacion, estrato, lider));
            
            }
            }
            catch (Exception e){}
        }
    }
    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO " + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %14.9s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
        
            try{
            ResultSet deudas = controlador.generarInformeDeudasPorProyecto(limiteInferior);
            while(deudas.next()){
                int id = deudas.getInt("ID_Proyecto");
                Double valor = deudas.getDouble("VALOR");
                System.out.println(String.format("%3d %,15.1f", id, valor));
            }
        }
        catch (Exception e){}
        }
    }
    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES " + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %14.9s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        
        try{
        ResultSet compras = controlador.generarInformeComprasDeLider();
            while(compras.next()){
                String lider = compras.getString("LIDER");
                Double valor = compras.getDouble("VALOR");
                System.out.println(String.format("%-25s %,15.1f", lider, valor));
            }
        }
        catch (Exception e){}
    }
}
