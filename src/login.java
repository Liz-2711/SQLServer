import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class login extends JFrame {

    private JButton loginButton;
    private JPasswordField txtPass;
    private JComboBox txtUser;
    private JPanel panel1;
    private JTextField txtPort;
    private JTextField txtServer;

    private JMenuBar mnubar;

    private JMenu mnu;

    private JMenuItem salir;
    public login(){
       super("SQL");
        setContentPane(panel1);

        //jComboBox.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
        loadUsers lu = new loadUsers();
        txtUser.setModel(new DefaultComboBoxModel<String>(lu.getUsers().toArray(new String[0])));

      /*  mnubar = new JMenuBar();
        mnu= new JMenu("Archivo");
        salir= new JMenuItem("Salir");
        mnubar.add(mnu);
        mnu.add(salir);

        setJMenuBar(mnubar);*/
;
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                String user= txtUser.getSelectedItem().toString();
                String pass= new String(txtPass.getPassword());
                String server = txtServer.getText();
                String port = txtPort.getText();
                System.out.println(pass);

                String url = "jdbc:sqlserver://" + server + "\\SQLEXPRESS:" + port + ";database=Chinook;encrypt=true;trustServerCertificate=true";
                //String connectionUrl = "jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=NewTest;integratedSecurity=true;encrypt=true;trustServerCertificate=true" ;
                //con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=Chinook;integratedSecurity=true;trustServerCertificate=true");
                try {
                    Connection con = DriverManager.getConnection(url,user, pass);
                    //System.out.println("yas queeeen");
                    JFrame j = new Menu(user, pass);
                    j.setSize(600,600);
                    j.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Bienvenido "+user+" a SQL SERVER");

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    //System.out.print("Nos sucessful"+e.toString());
                    //System.out.println("try again"+ e.toString());
                    e.printStackTrace();
                }
                //JOptionPane.showMessageDialog(null,"Bienvenido "+user+" a SQL SERVER");
            }
        });
    }
}
