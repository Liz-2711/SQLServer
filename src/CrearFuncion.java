import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CrearFuncion extends JFrame {
    private JPanel panel;

    public CrearFuncion() {
        setContentPane(panel);
        panel.setLayout(null);

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(4,178,217));
        panelHeader.setBounds(0,0,700,10);
        panelHeader.setVisible(true);
        panel.add(panelHeader);

        JPanel footer = new JPanel();
        footer.setBackground(new Color(242,92,5));
        footer.setBounds(0,640,700,20);
        footer.setVisible(true);
        panel.add(footer);

        JLabel titulo = new JLabel();
        titulo.setBounds(50, 20, 400, 20);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(Color.white);
        titulo.setText("CREAR FUNCION");
        titulo.setVisible(true);
        panel.add(titulo);

        JLabel lblNombre = new JLabel();
        lblNombre.setText("Ingrese nombre de la función: ");
        lblNombre.setForeground(Color.white);
        lblNombre.setBounds(50, 50, 200, 20);
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNombre.setVisible(true);
        panel.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(50, 70, 200, 20);
        txtNombre.setVisible(true);
        panel.add(txtNombre);

        JLabel lblParam = new JLabel();
        lblParam.setText("Ingrese los parametros de la función (Param1;Param2...): ");
        lblParam.setForeground(Color.white);
        lblParam.setBounds(50, 100, 350, 20);
        lblParam.setFont(new Font("Arial", Font.PLAIN, 12));
        lblParam.setVisible(true);
        panel.add(lblParam);

        JTextField txtParam = new JTextField();
        txtParam.setBounds(50, 130, 580, 40);
        txtParam.setVisible(true);
        panel.add(txtParam);

        JLabel lblDesc = new JLabel();
        lblDesc.setText("Ingrese la descripcion de la función: ");
        lblDesc.setForeground(Color.white);
        lblDesc.setBounds(50, 180, 230, 20);
        lblDesc.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDesc.setVisible(true);
        panel.add(lblDesc);

        JTextField txtDesc = new JTextField();
        txtDesc.setBounds(50, 210, 580, 50);
        txtDesc.setVisible(true);
        panel.add(txtDesc);

        JLabel lblSentencia = new JLabel();
        lblSentencia.setText("Ingrese la sentencia de creación: ");
        lblSentencia.setForeground(Color.white);
        lblSentencia.setBounds(50, 290, 230, 20);
        lblSentencia.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSentencia.setVisible(true);
        panel.add(lblSentencia);

        JTextField txtSentencia = new JTextField();
        txtSentencia.setBounds(50, 310, 580, 270);
        txtSentencia.setVisible(true);
        panel.add(txtSentencia);

        JButton btnCrearFunc = new JButton();
        btnCrearFunc.setBounds(480, 600, 150, 30);
        btnCrearFunc.setText("Crear Funcion");
        btnCrearFunc.setVisible(true);
        panel.add(btnCrearFunc);

        btnCrearFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrlConexion url = new UrlConexion();

                try {
                    String _nombre = txtNombre.getText() + ";", _param = txtParam.getText() + "#", _desc = txtDesc.getText() + ";";

                    String filenameN = "src//FunctionFiles//UF.txt";
                    FileWriter fwN = new FileWriter(filenameN,true);
                    fwN.write(_nombre);
                    fwN.close();

                    String filenameP = "src//FunctionFiles//UF_2.txt";
                    FileWriter fwP = new FileWriter(filenameP,true);
                    fwP.write(_param);
                    fwP.close();

                    String filenameD = "src//FunctionFiles//UF_Desc.txt";
                    FileWriter fwD = new FileWriter(filenameD,true);
                    fwD.write(_desc);
                    fwD.close();

                    url.setCon(url.getUser(), url.getPass(), url.getServer(), "Chinook");
                    Statement st = url.getCon().createStatement();
                    String query = txtSentencia.getText();
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Función Creada con exito!");

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

}
