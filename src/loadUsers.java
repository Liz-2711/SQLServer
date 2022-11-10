import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class loadUsers {


    public String getServerName() {
        try {
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(url,"sa", "1234");

            String server = "";

            Statement st= con.createStatement();
            String query="SELECT @@SERVERNAME";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                server = rs.getString(1);
            }

            return server;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getUsers() {
        try {
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(url,"sa", "1234");

            ArrayList<String> users = new ArrayList<String>();

            Statement st= con.createStatement();
            String query="SELECT name FROM sys.sql_logins WHERE name != '##MS_PolicyTsqlExecutionLogin##' AND name != '##MS_PolicyEventProcessingLogin##'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                users.add(rs.getString("name"));
            }

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
