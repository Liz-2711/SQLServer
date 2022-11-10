import java.sql.*;

public class UrlConexion {

    Connection con = null;
    String user = "", pass = "", server = "";

    public void setCon(String user, String pass, String server, String db) {
        String _db = ";database=";

        try {
            if(db.equals("")) {
                String url = "jdbc:sqlserver://"+ server + "\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true";
                this.con = DriverManager.getConnection(url, user, pass);
                this.user = user;
                this.pass = pass;
                this.server = server;
            }
            else {
                String url = "jdbc:sqlserver://"+ server + "\\SQLEXPRESS:1433;database=" + db + ";encrypt=true;trustServerCertificate=true";
                this.con = DriverManager.getConnection(url, user, pass);
                this.user = user;
                this.pass = pass;
                this.server = server;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getCon() {
        return con;
    }

    public String getUser() {return user;}

    public String getPass() {return pass;}

    public String getServer() { return server; }

}
