import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
    
    public void inicializar(){
        
        setTitle("Programa Ministerio de vivienda");
        setSize(600,520);
        setMinimumSize(new Dimension(500,520));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JTabbedPane pestañas = new JTabbedPane();
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        TablaCslt1 tabla1 = new TablaCslt1();
        panel1.add(tabla1, BorderLayout.CENTER);
        pestañas.addTab("Primer informe", panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        TablaCslt2 tabla2 = new TablaCslt2();
        panel2.add(tabla2, BorderLayout.CENTER);
        pestañas.addTab("Segundo informe", panel2);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        TablaCslt3 tabla3 = new TablaCslt3();
        panel3.add(tabla3, BorderLayout.CENTER);
        pestañas.addTab("Tercer informe", panel3);
        
        getContentPane().add(pestañas);

        setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        GUI ventana = new GUI();
        ventana.inicializar();
    }
}
