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

public class Indices extends JFrame{
    private JTextField textField1;
    private JButton crearButton;
    private JButton clearbutton;
    private JTable table1;
    private JTextField textField2;
    private JButton mostrarColumnasButton;
    private JButton mostrarIndicesButton;
    private JPanel panel1;
    private JButton menuPrincipalButton;

    public Indices(String user, String pass) {

        setContentPane(panel1);


        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection con = null;
                String Tabla = textField1.getText();
                String Columns = textField2.getText();

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                    int count = 0;
                    Statement st = con.createStatement();
                    String query = "CREATE NONCLUSTERED INDEX IX_"+Tabla+"_"+Columns+"\n" +
                            "on "+Tabla+"("+Columns+");";
                    System.out.println("CREATE NONCLUSTERED INDEX IX_"+Tabla+"_"+Columns+"\n" +
                            "on "+Tabla+"("+Columns+");");
                    st.executeUpdate(query);

                 //   ResultSet rs = st.executeQuery(query);
                   // System.out.println("\n"+st.toString());
                    //ResultSetMetaData rsmd = rs.getMetaData();

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


            }
        });
        mostrarIndicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection con = null;
                String Tabla = textField1.getText();
                String Columns = textField2.getText();
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                    int count = 0;
                    Statement st = con.createStatement();
                    String query = "SELECT i.name AS index_name\n" +
                            "    ,COL_NAME(ic.object_id,ic.column_id) AS column_name\n" +
                            "    ,ic.index_column_id\n" +
                            "    ,ic.key_ordinal\n" +
                            ",ic.is_included_column\n" +
                            "FROM sys.indexes AS i\n" +
                            "INNER JOIN sys.index_columns AS ic\n" +
                            "    ON i.object_id = ic.object_id AND i.index_id = ic.index_id\n" +
                            "WHERE i.object_id = OBJECT_ID('" + Tabla + "');";
                    System.out.println(query);
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
        mostrarColumnasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Tabla = textField1.getText();
                String Columns = textField2.getText();
                Connection con = null;

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                    int count = 0;
                    Statement st = con.createStatement();
                    String query = "SELECT TABLE_NAME,COLUMN_NAME \n" +
                            "FROM INFORMATION_SCHEMA.COLUMNS";
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

        clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                table1.setModel(new DefaultTableModel());
            }
        });
        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                JFrame frame=  new Menu(user, pass);
                frame.setSize(800,800);
                frame.setVisible(true);
            }
        });
    }
}
/*
CREATE NONCLUSTERED INDEX IX_Album_title
on Album(title);


 */
/*
SELECT i.name AS index_name
    ,COL_NAME(ic.object_id,ic.column_id) AS column_name
    ,ic.index_column_id
    ,ic.key_ordinal
,ic.is_included_column
FROM sys.indexes AS i
INNER JOIN sys.index_columns AS ic
    ON i.object_id = ic.object_id AND i.index_id = ic.index_id
WHERE i.object_id = OBJECT_ID('Album');
 */
/*

SELECT TABLE_NAME,COLUMN_NAME
FROM INFORMATION_SCHEMA.COLUMNS

 *//*

 DROP INDEX table_name.index_name;
 */