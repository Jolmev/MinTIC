import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    final private Font fuenteErrores = new Font("Times New Roman", Font.BOLD, 18);
    
    private boolean consultarBD(String consulta){
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/MinTIC/Ciclo 2 Programacion/Bases de datos SQL/universidad38.db");
            System.out.println("Conexión abierta con la base de datos");
  
            Statement stmt = c.createStatement();
            stmt.executeUpdate(consulta);
            stmt.close();
            c.close();
            System.out.println("La consulta ha sido realizada!");
            return true; // La operacion se llevo a cabo con exito
          } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return false; // La operacion no se pudo realizar
          }
    }

    public void inicializar(){
        JLabel lbErrorCedula = new JLabel();
        lbErrorCedula.setFont(fuenteErrores);
        lbErrorCedula.setForeground(Color.RED);
        
        JLabel lbCedula = new JLabel("Cedula");
        lbCedula.setFont(mainFont);
        
        JTextField tfCedula = new JTextField();
        tfCedula.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){

            }
            @Override
            public void focusLost(FocusEvent e){
                try{
                    Double numero = Double.parseDouble(tfCedula.getText());
                    lbErrorCedula.setText("");
                }
                catch(NumberFormatException nfe){
                    lbErrorCedula.setText("Ingrese una cedula valida");
                    tfCedula.setText("");
                }
            }
        });
        
        JLabel lbPrimerNombre = new JLabel("Primer nombre");
        lbPrimerNombre.setFont(mainFont);

        JTextField tfPrimerNombre = new JTextField();

        JLabel lbApellido = new JLabel("Apellido");
        lbApellido.setFont(mainFont);
        
        JTextField tfApellido = new JTextField();

        JLabel lbCorreo = new JLabel("Correo electronico");
        lbCorreo.setFont(mainFont);
        
        JTextField tfCorreo = new JTextField();

        JLabel lbDireccion = new JLabel("Direccion");
        lbDireccion.setFont(mainFont);
        
        JTextField tfDireccion = new JTextField();

        JLabel lbFecha = new JLabel("Fecha de nacimiento");
        lbFecha.setFont(mainFont);
        
        JTextField tfFecha = new JTextField();

        JLabel lbCiudad = new JLabel("Ciudad");
        lbCiudad.setFont(mainFont);
        JComboBox<String> cbCiudad = new JComboBox<>();
        cbCiudad.addItem("");
        cbCiudad.addItem("Bogota");
        cbCiudad.addItem("Cali");
        cbCiudad.addItem("Pereira");
        cbCiudad.addItem("Cartago");
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(8,2,5,5));
        panelFormulario.add(lbCedula);
        panelFormulario.add(tfCedula);
        panelFormulario.add(lbPrimerNombre);
        panelFormulario.add(tfPrimerNombre);
        panelFormulario.add(lbApellido);
        panelFormulario.add(tfApellido);
        panelFormulario.add(lbCorreo);
        panelFormulario.add(tfCorreo);
        panelFormulario.add(lbDireccion);
        panelFormulario.add(tfDireccion);
        panelFormulario.add(lbFecha);
        panelFormulario.add(tfFecha);
        panelFormulario.add(lbCiudad);
        panelFormulario.add(cbCiudad);
        panelFormulario.add(lbErrorCedula);
        
        // JTextArea taMensaje = new JTextArea("Informacion del usuario");
        TablaClientes tabla = new TablaClientes();
        
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(mainFont);
        
        btnEnviar.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                if(!"".equals(tfPrimerNombre.getText()) && !"".equals(tfApellido.getText()) && !"".equals(tfCedula.getText())){
                
                String nombre = tfPrimerNombre.getText();
                String apellido = tfApellido.getText();
                // String info = "Nombre: " + nombre + " " + apellido + "\nCedula: " + tfCedula.getText() + "\nDireccion: " + tfDireccion.getText() + "\nCorreo electronico: " + tfCorreo.getText() + "\nCiudad: " + cbCiudad.getSelectedItem() + "\n\n";
                
                Integer idciudad = 1;
                String ciudadSeleccionada = cbCiudad.getSelectedItem().toString();
                
                switch (ciudadSeleccionada){
                    case "":{
                        idciudad = 0;
                        break;
                    }
                    case "Bogota":{
                        idciudad = 1;
                        break;
                    }
                    case "Cali":{
                        idciudad = 2;
                        break;
                    }
                    case "Pereira":{
                        idciudad = 3;
                        break;
                    }
                    case "Cartago":{
                        idciudad = 1;
                        break;
                    }
                }

                String sql = "INSERT INTO clientes (cedula, nombre, apellido, correoe, direccion, fecha_nacimiento, ciudad_nacimiento) \nVALUES (";
                sql += tfCedula.getText() + ", ";
                sql += "'" + tfPrimerNombre.getText() + "', ";
                sql += "'" + tfApellido.getText() + "', ";
                if(!"".equals(tfCorreo.getText())){
                    sql += "'" + tfCorreo.getText() + "', ";
                    }
                else{
                    sql += "NULL,";
                }
                if(!"".equals(tfDireccion.getText())){
                    sql += "'" + tfDireccion.getText() + "', ";
                    }
                else{
                    sql += "NULL,";
                }
                if(!"".equals(tfFecha.getText())){
                    sql += "'" + tfFecha.getText() + "', ";
                    }
                else{
                    sql += "NULL,";
                }
                if(idciudad != 0){
                    sql += idciudad;
                }
                else{
                    sql += "NULL";
                }
                sql += ")";

                boolean resultado = consultarBD(sql);
                String mensaje = "";
                if(resultado == true){
                    mensaje = "Se realizo la consulta exitosamente";
                    JOptionPane.showMessageDialog(panelFormulario, mensaje, "Consulta exitosa", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    mensaje = "Hubo un problema al realizar la consulta";
                    JOptionPane.showMessageDialog(panelFormulario, mensaje, "Error al realizar la consulta", JOptionPane.ERROR_MESSAGE);
                }
                // taMensaje.setText(sql + "\n\n" + mensaje);
                tabla.actualizarDatos();
                }
            else{
                JOptionPane.showMessageDialog(panelFormulario, "No se puede realizar la consulta sin los datos basicos (nombre, apellido y cedula)", "Error", JOptionPane.ERROR_MESSAGE);
            }

            }
        });

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(mainFont);
        
        btnBorrar.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                tfPrimerNombre.setText("");
                tfApellido.setText("");
                // taMensaje.setText("");
                tfCedula.setText("");
                tfDireccion.setText("");
                tfCorreo.setText("");
                tfFecha.setText("");
                lbErrorCedula.setText("");
                cbCiudad.setSelectedItem("");
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,2,5,5));
        panelBotones.add(btnEnviar);
        panelBotones.add(btnBorrar);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(128,128,255));
        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        // panelPrincipal.add(taMensaje, BorderLayout.CENTER);
        panelPrincipal.add(tabla, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        setTitle("Bienvenido a nuestra aplicacion!");
        setSize(900,700);
        setMinimumSize(new Dimension(600,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }   
    
    

    public static void main(String[] args) throws Exception{
        MainFrame ventana = new MainFrame();
        ventana.inicializar();
    }

    

}
