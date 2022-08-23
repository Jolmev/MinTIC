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

        setLayout(new BorderLayout());
        JPanel panelInforme = new JPanel();
        add(panelInforme, BorderLayout.CENTER);
        TablaCslt1 tabla1 = new TablaCslt1();
        TablaCslt2 tabla2 = new TablaCslt2();
        TablaCslt3 tabla3 = new TablaCslt3();
        panelInforme.add(tabla1);


        m11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panelInforme.removeAll();
                panelInforme.add(tabla1);
                panelInforme.revalidate();
            }
        });

        m12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panelInforme.removeAll();
                panelInforme.add(tabla2);
                panelInforme.revalidate();
            }
        });

        m13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panelInforme.removeAll();
                panelInforme.add(tabla3);
                panelInforme.revalidate();
            }
        });

        setTitle("Programa Ministerio de Vivienda");
        
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
