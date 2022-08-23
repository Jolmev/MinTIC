package model;
import java.sql.Connection;

import util.*;
import java.sql.*;


public class DeudasPorProyecto {
    Connection c = JDBCUtilities.getConnection();
    public ResultSet datos;

    public DeudasPorProyecto(Double limiteInferior) throws Exception{
        String consulta = "SELECT ID_Proyecto, SUM(Compra.Cantidad*MaterialConstruccion.Precio_Unidad) AS VALOR FROM Compra JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion WHERE Compra.Pagado = 'No' GROUP BY ID_Proyecto HAVING VALOR > "+ String.valueOf(limiteInferior) +" ORDER BY VALOR DESC";
        Statement stmt = c.createStatement();
        datos = stmt.executeQuery(consulta);
        //c.close();
    }
}
