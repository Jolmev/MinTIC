import javax.swing.*;
import java.awt.*;

public class TablaCslt1 extends JPanel {
    ModeloCslt1 modelo = new ModeloCslt1();
    public TablaCslt1()
    {
        setLayout(new BorderLayout());
        
        JTable tabla = new JTable(modelo);

        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
    }
}