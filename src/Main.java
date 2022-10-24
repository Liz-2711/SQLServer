import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             JFrame frame= new tables();
             frame.setSize(500,500);
             frame.setVisible(true);
            }
        });








/*
String user="guest";
String pass="1234";
       String connectionUrl  = "jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS;DatabaseName=NewTest;encrypt=true;trustServerCertificate=true;";
      //String connectionUrl = "jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=NewTest;integratedSecurity=true;encrypt=true;trustServerCertificate=true" ;
        try {
            Connection con = DriverManager.getConnection(connectionUrl,user, pass);
            System.out.println("yas queeeen");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //System.out.print("Nos sucessful"+e.toString());
            System.out.println("try again"+ e.toString());
                    e.printStackTrace();
        }
 */
/*
SqlConnection sqlconn = new SqlConnection("server=.\\sqlexpress;database=db;user id=ur userid;password=ur password;");
 */



    }
}