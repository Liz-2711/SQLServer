
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
import java.util.Arrays;
public class users extends  JFrame{
    private JTable table1;
    private JButton mostrarUsuariosButton;
    private JButton borrarButton;
    private JPanel panel1;

    public users(String user){

    setContentPane(panel1);
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                table1.setModel(new DefaultTableModel());
            }
        });

        mostrarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="SELECT * FROM master.sys.database_principals;";
                    ResultSet rs = st.executeQuery(query);
                    ResultSetMetaData rsmd= rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    int cols=rsmd.getColumnCount();
                    String[] colName=new String [cols];
                    for(int i=0; i<cols;i++) {
                        colName[i] = rsmd.getColumnName(i + 1);
                        count++;

                    }
                    model.setColumnIdentifiers(colName);
                    String data;
                    String[] row=new String[count];

                    while (rs.next()){
                        for(int x=1;x<=count;x++){
                            data= rs.getString(x);
                            row[x-1] = data;
                            //  System.out.println(Arrays.toString(row));
                        }



                        model.addRow(row);

                    }

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }



            }
        });

}


}
