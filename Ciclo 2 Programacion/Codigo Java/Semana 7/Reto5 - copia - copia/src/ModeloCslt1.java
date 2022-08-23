import java.sql.*;
import javax.swing.table.*;

public class ModeloCslt1 extends DefaultTableModel{
    
    ResultSet datos;
    public ModeloCslt1(){
        this.addColumn("ID");
        this.addColumn("Nombre");
        this.addColumn("Primer apellido");
        this.addColumn("Ciudad de residencia");
        
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/MinTIC/Ciclo 2 Programacion/Bases de datos SQL/ProyectosConstruccion.db");
            System.out.println("Conexión abierta con la base de datos");
  
            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Lider AS ID, Nombre, Primer_Apellido AS 'Primer apellido', Ciudad_Residencia AS 'Ciudad de residencia' FROM Lider ORDER BY Ciudad_Residencia";
            datos = stmt.executeQuery(consulta);
            
            while(datos.next()){
                Object [] fila = new Object[4];
                for(int i = 0; i<4; i++){
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