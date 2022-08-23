import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;

public class ModeloClientes extends DefaultTableModel{
    
    ResultSet datos;
    public ModeloClientes(){
        this.addColumn("cedula");
        this.addColumn("nombre");
        this.addColumn("apellido");
        this.addColumn("correo electronico");
        this.addColumn("fecha nacimiento");
        this.addColumn("direccion");
        this.addColumn("ciudad nacimiento");

        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/MinTIC/Ciclo 2 Programacion/Bases de datos SQL/universidad38.db");
            System.out.println("Conexión abierta con la base de datos");
  
            Statement stmt = c.createStatement();
            String consulta = "SELECT cedula, clientes.nombre AS 'nombre', apellido, correoe AS 'correo_electronico', fecha_nacimiento, direccion, ciudades.nombre AS 'ciudad_nacimiento' FROM clientes LEFT JOIN ciudades on clientes.ciudad_nacimiento = ciudades.id";
            datos = stmt.executeQuery(consulta);
            
            while(datos.next()){
                Object [] fila = new Object[7];
                for(int i = 0; i<7; i++){
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

    public void actualizarInfo(){
        int numfilas = this.getRowCount();
        for (int i = numfilas-1; i>=0; i--){
            this.removeRow(i);
        }

        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/MinTIC/Ciclo 2 Programacion/Bases de datos SQL/universidad38.db");
            System.out.println("Conexión abierta con la base de datos");
  
            Statement stmt = c.createStatement();
            String consulta = "SELECT cedula, clientes.nombre AS 'nombre', apellido, correoe AS 'correo_electronico', fecha_nacimiento, direccion, ciudades.nombre AS 'ciudad_nacimiento' FROM clientes LEFT JOIN ciudades on clientes.ciudad_nacimiento = ciudades.id";
            datos = stmt.executeQuery(consulta);
            
            while(datos.next()){
                Object [] fila = new Object[7];
                for(int i = 0; i<7; i++){
                    //fila[i] = datos.getObject(i+1);
                    fila[i] = datos.getString(i+1);
                }
                this.addRow(fila);
            }
            
            stmt.close();
            c.close();
            System.out.println("La consulta ha sido realizada!");
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          }
          this.fireTableDataChanged();
    }
}
