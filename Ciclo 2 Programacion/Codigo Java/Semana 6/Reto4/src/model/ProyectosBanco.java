package model;
import java.sql.Connection;

import util.*;
import java.sql.*;

public class ProyectosBanco {
    Connection c = JDBCUtilities.getConnection();
    public ResultSet datos;

    public ProyectosBanco(String banco) throws Exception{
        String consulta = "SELECT ID_Proyecto, Constructora, Ciudad, Proyecto.Clasificacion, Tipo.Estrato, Lider.Nombre || ' ' || Lider.Primer_Apellido || ' ' || Lider.Segundo_Apellido AS LIDER FROM Proyecto JOIN Tipo ON Proyecto.ID_Tipo = Tipo.ID_Tipo JOIN Lider ON Proyecto.ID_Lider = Lider.ID_Lider WHERE Banco_Vinculado = '" + banco + "' ORDER BY Fecha_Inicio DESC, Ciudad, Constructora";
        Statement stmt = c.createStatement();
        datos = stmt.executeQuery(consulta);
        //c.close();
    }
}
