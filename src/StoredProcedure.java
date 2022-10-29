import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StoredProcedure extends JFrame{
    private JButton INSERTARButton;
    private JPanel panel1;
    private JButton ELIMINARButton;
    private JButton UPDATEButton;
    private JTextField InsertarTxtfield;
    private JTextField updatetxt;
    private JTextField eliminartxt;
    private JTextField tablaTextField;
    private JButton syntaxisDeLasTablasButton;

    public StoredProcedure(String user){
       setContentPane(panel1);

       String SP=tablaTextField.getText();
       String Insertw = InsertarTxtfield.getText();
       String Updatew = updatetxt.getText();
       String Elimimarw = eliminartxt.getText();



       INSERTARButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               Connection con = null;
               String SP=tablaTextField.getText();
               String Insertw = InsertarTxtfield.getText();
               try {
                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                   con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                   int count = 0;
                   Statement st = con.createStatement();
                   String query = "SET IDENTITY_INSERT Album ON EXEC "+SP+" @Action = 'INSERT',\n" +Insertw+
                           "SET IDENTITY_INSERT Album OFF;";
                   System.out.println("SET IDENTITY_INSERT Album ON EXEC "+SP+" @Action = 'INSERT',\n" +Insertw+
                           "SET IDENTITY_INSERT Album OFF;");
                    st.executeUpdate(query);
                   //ResultSetMetaData rsmd = rs.getMetaData();

               } catch (SQLException | ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
           }
           });
       UPDATEButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               Connection con = null;
               String SP=tablaTextField.getText();

               String Updatew = updatetxt.getText();


               try {
                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                   con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                   int count = 0;
                   Statement st = con.createStatement();
                   String query = "EXEC "+SP+"  @Action = 'UPDATE',\n" +Updatew+
                           ";";
                   System.out.println(query);
                   st.executeUpdate(query);
               } catch (SQLException | ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
           }
       });
       ELIMINARButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               Connection con = null;
               String SP=tablaTextField.getText();
               String Elimimarw = eliminartxt.getText();

               try {
                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                   con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                   int count = 0;
                   Statement st = con.createStatement();
                   String query = "EXEC "+SP+" @Action = 'DELETE',\n" +Elimimarw+
                           ";";
                   System.out.println(query);
                   st.executeUpdate(query);

                   JOptionPane.showMessageDialog(null,"Procedimiento realizado!!");
               } catch (SQLException | ClassNotFoundException e) {
                   JOptionPane.showMessageDialog(null,"Error.."+ e.toString());
                   throw new RuntimeException(e);

               }

           }
       });
   }
}
