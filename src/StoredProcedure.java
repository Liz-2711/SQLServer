import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JTextField tablename;
    private JTable table1;
    private JButton menuPrincipalButton;
    private JButton mostrarTablaButton;

    public StoredProcedure(String user, String pass){
       setContentPane(panel1);

       String SP=tablaTextField.getText();
       String Insertw = InsertarTxtfield.getText();
       String Updatew = updatetxt.getText();
       //String Elimimarw = eliminartxt.getText();


/*SELECT *
from Playlist
order by PlaylistId desc;*/
       INSERTARButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               Connection con = null;
               String SP=tablaTextField.getText();
               String TN = tablename.getText();
               String Insertw = InsertarTxtfield.getText();
               try {
                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                   con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                   int count = 0;
                   Statement st = con.createStatement();
                   String query = "SET IDENTITY_INSERT "+TN+" ON EXEC "+SP+" @Action = 'INSERT',\n" +Insertw+
                           "SET IDENTITY_INSERT "+TN+" OFF;";
                   System.out.println("SET IDENTITY_INSERT "+TN+" ON EXEC "+SP+" @Action = 'INSERT',\n" +Insertw+
                           "SET IDENTITY_INSERT "+TN+" OFF;");
                    st.executeUpdate(query);
                   //ResultSetMetaData rsmd = rs.getMetaData();4
                   JOptionPane.showMessageDialog(null,"Procedimiento realizado!!");

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
                   con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                   int count = 0;
                   Statement st = con.createStatement();
                   String query = "EXEC "+SP+"  @Action = 'UPDATE',\n" +Updatew+
                           ";";
                   System.out.println(query);
                   st.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Procedimiento realizado!!");
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
                   con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

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


        syntaxisDeLasTablasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*SELECT ROUTINE_DEFINITION
FROM INFORMATION_SCHEMA.ROUTINES
WHERE ROUTINE_TYPE = 'PROCEDURE';*/

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", user, pass);

                    int count=0;
                    Statement st= con.createStatement();
                    String query="SELECT ROUTINE_DEFINITION\n" +
                            "FROM INFORMATION_SCHEMA.ROUTINES\n" +
                            "WHERE ROUTINE_TYPE = 'PROCEDURE';";
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
