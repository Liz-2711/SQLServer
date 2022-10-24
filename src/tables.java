
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class tables extends JFrame {
    private JButton albums;
    private JPanel panel1;
    private JButton button2;
    private JTable table1;

    public tables(){

        setContentPane(panel1);

        albums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection con= null;
                try {
                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");


                    Statement st= con.createStatement();
                    String query="select * from Album;";
                    ResultSet rs = st.executeQuery(query);
                    ResultSetMetaData rsmd= rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    int cols=rsmd.getColumnCount();
                    String[] colName=new String [cols];
                    for(int i=0; i<cols;i++)
                        colName[i]=rsmd.getColumnName(i+1);
                         model.setColumnIdentifiers(colName);




                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }



            }
        });
    }
    /*
    Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","teoria");
				Statement st=con.createStatement();
				String query="SELECT MoviTransp.*, paquete.Estado\r\n"
						+ "     FROM MoviTransp\r\n"
						+ "LEFT JOIN paquete\r\n"
						+ "ON MoviTransp.NumOrden = paquete.Numero_Orden;";
				ResultSet rs = st.executeQuery(query);
				ResultSetMetaData rsmd= rs.getMetaData();
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int cols=rsmd.getColumnCount();
				String[] colName=new String [cols];
				for(int i=0; i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
     */
}
