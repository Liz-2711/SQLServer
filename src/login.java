import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class login extends JFrame {

    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPanel panel1;
private JMenuBar mnubar;
private JMenu mnu;
private JMenuItem salir;
    public login(){
       super("SQL");
        setContentPane(panel1);

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


                String user=textField1.getText();
                String pass= new String(passwordField1.getPassword());
                System.out.println(pass);
                String connectionUrl  = "jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS;DatabaseName=Chinook;encrypt=true;trustServerCertificate=true;";
                //String connectionUrl = "jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=NewTest;integratedSecurity=true;encrypt=true;trustServerCertificate=true" ;
                try {
                    Connection con = DriverManager.getConnection(connectionUrl,user, pass);
                    //System.out.println("yas queeeen");
                    JFrame j = new tables(user);
                    j.setSize(800,800);
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
