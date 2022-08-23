import java.sql.*;
import javax.swing.table.*;

public class ModeloCslt3 extends DefaultTableModel{
    
    ResultSet datos;
    public ModeloCslt3(){
        this.addColumn("ID Compra");
        this.addColumn("Constructora");
        this.addColumn("Banco vinculado");
        
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/MinTIC/Ciclo 2 Programacion/Bases de datos SQL/ProyectosConstruccion.db");
            System.out.println("Conexión abierta con la base de datos");
  
            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Compra AS 'ID Compra', Constructora, Banco_Vinculado AS 'Banco vinculado' FROM Compra JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto WHERE Ciudad = 'Salento' AND Proveedor = 'Homecenter'";
            datos = stmt.executeQuery(consulta);
            
            while(datos.next()){
                Object [] fila = new Object[3];
                for(int i = 0; i<3; i++){
                    fila[i] = datos.getObject(i+1);
                }
                this.addRow(fila);
            }
            
            stmt.close();
            c.close();
            System.out.println("La consulta ha sido realizada!");
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          }
    }
}