import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Secuencias extends JFrame{
    private JTable table1;
    private JPanel panel1;
    private JButton mostrarSecuenciasButton;
    private JButton menuPrincipalButton;

    /*CREATE SEQUENCE PLId_Count

AS tinyint

START WITH 19

INCREMENT BY 1

GO

Select* from Playlist

SET IDENTITY_INSERT Playlist ON
Insert into Playlist(PlaylistId,Name)
VALUES(NEXT VALUE FOR PLId_Count, 'Victoriuos')

SET IDENTITY_INSERT Playlist OFF;

CREATE SEQUENCE ALbId_Count

AS tinyint

START WITH 19

INCREMENT BY 1

GO

*/

    public Secuencias(String user, String pass) {
        setContentPane(panel1);
        mostrarSecuenciasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                    int count=0;
                    Statement st= con.createStatement();
                    String query=" SELECT * FROM sys.SEQUENCES";
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


                table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
