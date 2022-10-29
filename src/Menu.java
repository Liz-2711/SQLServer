import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton tablasButton;
    private JButton indicesButton;
    private JButton usuariosButton;
    private JButton tablespacesButton;
    private JButton vistasButton;
    private JButton desparadosresButton;
    private JButton funcionesButton;
    private JButton paquetesButton;
    private JButton procedimientosAlmaacenadosButton;
    private JButton secuenciasOGeneradoresButton;
    private JPanel panel1;

    public Menu(String user) {

        setContentPane(panel1);
        tablasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new tables(user);
                frame.setSize(1500,800);
                frame.setVisible(true);
            }
        });


        indicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new tables(user);
                frame.setSize(800,800);
                frame.setVisible(true);
            }
        });vistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // JFrame frame=  new vistas(user);

            }
        });usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new users(user);
                frame.setSize(800,800);
                frame.setVisible(true);
            }
        });tablespacesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              //  JFrame frame=  new tablespaces(user);
            }
        });desparadosresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new tables(user);
                frame.setSize(1500,800);
                frame.setVisible(true);
            }
        });paquetesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              //  JFrame frame=  new páquetes(user);
            }
        });funcionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              //  JFrame frame=  new funciones(user);
            }
        });secuenciasOGeneradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // JFrame frame=  new secuencias(user);
            }
        });procedimientosAlmaacenadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new StoredProcedure(user);
                frame.setSize(1500,800);
                frame.setVisible(true);
            }
        });

    }
}
