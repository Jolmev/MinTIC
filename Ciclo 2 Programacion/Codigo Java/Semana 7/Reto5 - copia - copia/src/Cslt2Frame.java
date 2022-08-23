import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class Cslt2Frame extends JFrame {
      
    public void inicializar(){
        
        TablaCslt2 tabla = new TablaCslt2();
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(128,128,255));
        panelPrincipal.add(tabla, BorderLayout.CENTER);

        add(panelPrincipal);

        setTitle("Bienvenido a nuestra aplicacion!");
        setSize(500,650);
        setMinimumSize(new Dimension(500,600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }   
}