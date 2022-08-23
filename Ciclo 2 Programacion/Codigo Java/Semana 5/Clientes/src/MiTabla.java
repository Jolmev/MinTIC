import javax.swing.*;
import java.awt.*;

public class MiTabla extends JPanel {
    
    public MiTabla() {
        setLayout(new BorderLayout());
        JTable tabla = new JTable(new ModeloDatos());
        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
    }
   }