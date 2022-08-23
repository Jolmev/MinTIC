package controller;
import model.*;
import java.sql.*;

public class ReportesController {
    ProyectosBanco proyectos;
    DeudasPorProyecto deudas;
    ComprasDeLider compras;

    public ResultSet generarInformeProyectosBanco(String banco) throws Exception{
        proyectos = new ProyectosBanco(banco);
        return proyectos.datos;
    }

    public ResultSet generarInformeDeudasPorProyecto(Double limiteInferior) throws Exception{
        deudas = new DeudasPorProyecto(limiteInferior);
        return deudas.datos;
    }

    public ResultSet generarInformeComprasDeLider() throws Exception{
        compras = new ComprasDeLider();
        return compras.datos;
    }
}
