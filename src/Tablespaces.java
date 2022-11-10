import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Tablespaces extends JFrame{


    private JTable table;
    private JPanel panel1;

    public Tablespaces(String user, String pass){
        setContentPane(panel1);
        this.setSize(600, 650);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

            int count=0;
            Statement st= con.createStatement();
            String query="select * from sys.filegroups";
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd= rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols=rsmd.getColumnCount();
            String[] colName=new String [cols];

            for(int i=0; i<cols;i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                count++;
            }

            model.setColumnIdentifiers(colName);

            int i =0;
            String data;
            String[] row=new String[count];

            while (rs.next()){
                for(int x=1;x<=count;x++){
                    data= rs.getString(x);
                    row[x-1] = data;
                }

                model.addRow(row);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
