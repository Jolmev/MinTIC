package model;
import java.sql.Connection;

import util.*;
import java.sql.*;


public class ComprasDeLider {
    Connection c = JDBCUtilities.getConnection();
    public ResultSet datos;

    public ComprasDeLider() throws Exception{
        String consulta = "SELECT Lider.Nombre || ' ' || Lider.Primer_Apellido || ' ' || Lider.Segundo_Apellido AS LIDER, SUM(Compra.Cantidad*MaterialConstruccion.Precio_Unidad) AS VALOR FROM Lider JOIN Proyecto ON Lider.ID_Lider = Proyecto.ID_Lider JOIN Compra ON Proyecto.ID_Proyecto = Compra.ID_Proyecto JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion GROUP BY LIDER ORDER BY VALOR DESC LIMIT 10";
        Statement stmt = c.createStatement();
        datos = stmt.executeQuery(consulta);
        //c.close();
    }
}