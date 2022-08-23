import javax.swing.*;
import java.awt.*;

public class TablaClientes extends JPanel {
    ModeloClientes modelo = new ModeloClientes();
    public TablaClientes()
    {
        setLayout(new BorderLayout());
        
        JTable tabla = new JTable(modelo);

        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
    }

    public void actualizarDatos(){
        modelo.actualizarInfo();
    }
}
