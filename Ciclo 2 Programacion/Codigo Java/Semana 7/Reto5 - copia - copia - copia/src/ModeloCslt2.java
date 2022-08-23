import java.sql.*;
import javax.swing.table.*;

public class ModeloCslt2 extends DefaultTableModel{
    
    ResultSet datos;
    public ModeloCslt2(){
        this.addColumn("ID Proyecto");
        this.addColumn("Constructora");
        this.addColumn("Numero de habitaciones");
        this.addColumn("Ciudad");
        
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/MinTIC/Ciclo 2 Programacion/Bases de datos SQL/ProyectosConstruccion.db");
            System.out.println("Conexión abierta con la base de datos");
  
            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Proyecto AS 'ID Proyecto', Constructora, Numero_Habitaciones AS 'Numero de habitaciones', Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND (Ciudad = 'Barranquilla' OR Ciudad = 'Cartagena' OR Ciudad = 'Santa Marta')";
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
