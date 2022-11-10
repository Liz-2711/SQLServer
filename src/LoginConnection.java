import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginConnection extends JFrame {
    private JPanel panel;
    private JLabel logo;
    private JPanel panelFooter;

    public LoginConnection() {
        setContentPane(panel);
        panel.setLayout(null);

        panelFooter.setBounds(0,490,700,20);
        panelFooter.setVisible(true);

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(4,178,217));
        panelHeader.setBounds(0,0,700,10);
        panelHeader.setVisible(true);
        panel.add(panelHeader);

        logo.setBounds(335,65,50,50);
        ImageIcon imageIcon = new ImageIcon("src//logo.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        logo.setIcon(imageIcon);

        ArrayList<ArrayList> logins = new ArrayList<>();
        ArrayList<JButton> botones = new ArrayList<>();

        JLabel titulo = new JLabel();

        titulo.setBounds(20, 80, 400, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.white);
        titulo.setText("SQL SERVER STUDIO");
        titulo.setVisible(true);
        panel.add(titulo);

        loadUsers lu = new loadUsers();

        int size = lu.getUsers().size();
        int x = 20;

        for (int i = 0; i < size; i++) {
            ArrayList<String> log = new ArrayList<>();
            JButton boton = new JButton();

            boton.setText(lu.getUsers().get(i) + "; " + lu.getServerName());
            boton.setBounds(x, 150, 200, 60);
            boton.setBackground(new Color(106,152,171));
            boton.setForeground(new Color(255,255,255));
            x += 210;

            botones.add(boton);
            log.add(lu.getUsers().get(i));
            log.add(lu.getServerName());
            logins.add(log);

            boton.setVisible(true);
            panel.add(boton);
        }

        for (int i = 0; i < botones.size(); i++) {
            String userlogged = (String) logins.get(i).get(0);
            String server = (String) logins.get(i).get(1);

            botones.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel panel = new JPanel();

                    JLabel label = new JLabel("Ingrese contraseña de " + userlogged + ": ");
                    JPasswordField pass = new JPasswordField(25);
                    panel.add(label);
                    panel.add(pass);
                    String[] options = new String[]{"OK", "Cancel"};
                    int option = JOptionPane.showOptionDialog(null, panel, "The title",
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[1]);

                    if(option == 0) {
                        try {
                            UrlConexion url = new UrlConexion();
                            char[] password = pass.getPassword();
                            String finalPass = new String(password);
                            url.setCon(userlogged, finalPass, server, "");

                            JFrame j = new Menu(userlogged, finalPass);
                            j.setSize(600,600);
                            j.setVisible(true);
                            JOptionPane.showMessageDialog(null,"Bienvenido "+userlogged+" a SQL SERVER");

                        } catch (RuntimeException re) {
                            JOptionPane.showMessageDialog(null, "Conexión denegada; contraseña incorrecta");
                            re.printStackTrace();
                        }

                    }
                }
            });
        }

    }
}
