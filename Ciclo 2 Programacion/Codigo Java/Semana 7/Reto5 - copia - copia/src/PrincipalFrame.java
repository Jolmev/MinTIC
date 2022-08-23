import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrincipalFrame extends JFrame{
    
    public void inicializar(){
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Informes");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Informe Lideres");
        JMenuItem m12 = new JMenuItem("Proyecto casas campestres en la costa");
        JMenuItem m13 = new JMenuItem("Compras proyectos Salento");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);

        m11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Cslt1Frame ventana1 = new Cslt1Frame();
                ventana1.inicializar();
            }
        });

        m12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Cslt2Frame ventana2 = new Cslt2Frame();
                ventana2.inicializar();
            }
        });

        m13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Cslt3Frame ventana3 = new Cslt3Frame();
                ventana3.inicializar();
            }
        });

        setTitle("Programa Ministerio de Vivienda");
        setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.NORTH, mb);

        setSize(900,700);
        setMinimumSize(new Dimension(600,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        PrincipalFrame ventana = new PrincipalFrame();
        ventana.inicializar();
    }
}
