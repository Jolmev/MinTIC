import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MiTabla extends JPanel {
    public MiTabla() {
        setLayout(new BorderLayout());
        JTable tabla = new JTable(new ModeloDatos());
        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tutorial de Java, Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MiTabla(), BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
   }
   