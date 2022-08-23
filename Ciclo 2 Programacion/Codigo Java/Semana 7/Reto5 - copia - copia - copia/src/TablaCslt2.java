import javax.swing.*;
import java.awt.*;

public class TablaCslt2 extends JPanel {
    ModeloCslt2 modelo2 = new ModeloCslt2();
    public TablaCslt2()
    {
        setLayout(new BorderLayout());
        
        JTable tabla2 = new JTable(modelo2);

        JScrollPane panel2 = new JScrollPane(tabla2);
        add(panel2, BorderLayout.CENTER);
    }
}