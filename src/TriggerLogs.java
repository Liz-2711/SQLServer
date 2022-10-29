
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

public class TriggerLogs extends JFrame{
    private JButton albumButton;
    private JTable table1;
    private JButton borrarButton;
    private JButton artistbttn;
    private JButton customebttn;
    private JButton employeebttn;
    private JButton genrebttn;
    private JButton invoicebttn;
    private JButton invoiceLinebttn;
    private JButton mediabttn;
    private JButton playlistbttn;
    private JButton playlistTrackbttn;
    private JButton Trackbttn;
    private JPanel panel1;


    public TriggerLogs(String user){

        setContentPane(panel1);

        albumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection con= null;/*
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

                */
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsAlbum;";
                    ResultSet rs = st.executeQuery(query);
                    ResultSetMetaData rsmd= rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    int cols=rsmd.getColumnCount();
                    String[] colName=new String [cols];
                    for(int i=0; i<cols;i++) {
                        colName[i] = rsmd.getColumnName(i + 1);
                        count++;
                        //System.out.println(count);
                    }
                    model.setColumnIdentifiers(colName);
                    int i =0;
                    String data;
                    //String[] row;
                    String[] row=new String[count];
                    // System.out.println(count);
                    while (rs.next()){
                        // System.out.println(rs.getString(1));
                        for(int x=1;x<=count;x++){
                            // System.out.println(x);
                            data= rs.getString(x);
                            row[x-1] = data;
                            // System.out.println(x+"**"+data);
                            //System.out.println(Arrays.toString(row));
                        }
                   /*
                    String no, name, artist;
                    while(rs.next()){
                        no=rs.getString(1);
                        name=rs.getString(2);
                        artist=rs.getString(3);
                        String[] row = {no,name, artist};
                    */


                        model.addRow(row);
                        // System.out.println(Arrays.toString(row));
                    }






                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }



            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                table1.setModel(new DefaultTableModel());
            }
        });
        playlistTrackbttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                Connection con= null;/*
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

                */
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsPlaylistTrack;";
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




        Trackbttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                Connection con= null;

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsTrack;";
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



        playlistbttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                Connection con= null;/*
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

                */
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsPlaylist;";
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



        mediabttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                Connection con= null;/*
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

                */
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsMediaType;";
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

        invoiceLinebttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsInvoiceLine;";
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
        invoicebttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsInvoice;";
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

        genrebttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsGenre;";
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

        employeebttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsEmployee;";
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
        customebttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsCustomers;";
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
        artistbttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://REN-LIZ-27\\SQLEXPRESS:1433;DatabaseName=Chinook;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from LogsArtist;";
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
        /*******************************/
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
