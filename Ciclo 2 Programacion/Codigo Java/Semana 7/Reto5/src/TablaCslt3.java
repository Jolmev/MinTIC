import javax.swing.*;
import java.awt.*;

public class TablaCslt3 extends JPanel {
    ModeloCslt3 modelo = new ModeloCslt3();
    public TablaCslt3()
    {
        setLayout(new BorderLayout());
        
        JTable tabla = new JTable(modelo);

        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
    }
}