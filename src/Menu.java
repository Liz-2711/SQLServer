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
    private JButton btnConexiones;

    public Menu(String user, String pass) {

        setContentPane(panel1);
        tablasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new tables(user, pass);
                frame.setSize(1500,800);
                frame.setVisible(true);
            }
        });


        indicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new Indices(user, pass);
                frame.setSize(800,800);
                frame.setVisible(true);
            }
        });vistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Vistas v = new Vistas(user, pass);
                v.setSize(800, 800);
                v.setVisible(true);
            }
        });usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new users(user, pass);
                frame.setSize(800,800);
                frame.setVisible(true);
            }
        });tablespacesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Tablespaces t = new Tablespaces(user, pass);
                t.setVisible(true);
            }
        });desparadosresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new TriggerLogs(user, pass);
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
                Funciones f = new Funciones();
                f.setVisible(true);
                dispose();
            }
        });secuenciasOGeneradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new Secuencias(user, pass);
                frame.setSize(1500,800);
                frame.setVisible(true);
            }
        });procedimientosAlmaacenadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame=  new StoredProcedure(user, pass);
                frame.setSize(1500,800);
                frame.setVisible(true);
            }
        });

        btnConexiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexiones c = new Conexiones(user, pass);
                c.setVisible(true);
            }
        });
    }
}
