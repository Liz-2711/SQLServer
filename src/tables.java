
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
    private JTable table1;
    private JButton trackButton;
    private JButton playlistTrackButton;
    private JButton playlistButton;
    private JButton mediaTypeButton;
    private JButton invoiceLineButton;
    private JButton clearButton;
    private JButton invoice;
    private JButton genre;
    private JButton employee;
    private JButton customer;
    private JButton artist;
    private JButton btnFunciones;

    public tables(){

        setContentPane(panel1);

        btnFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions f = new Functions();
                f.setVisible(true);
            }
        });

        albums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection con= null;/*
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=Chinook;integratedSecurity=true;trustServerCertificate=true");


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
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Album;";
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
        btnFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                table1.setModel(new DefaultTableModel());
            }
        });
        playlistTrackButton.addActionListener(new ActionListener() {
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
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from PlaylistTrack;";
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




        trackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                Connection con= null;

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Track;";
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



        playlistButton.addActionListener(new ActionListener() {
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
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Playlist;";
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



        mediaTypeButton.addActionListener(new ActionListener() {
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
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from MediaType;";
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

        invoiceLineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from InvoiceLine;";
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
        invoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from invoice;";
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

        genre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Genre;";
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

        employee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Employee;";
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
        customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Customer;";
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
        artist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con= null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Chinook;encrypt=true;trustServerCertificate=true", "sa", "1234");

                    int count=0;
                    Statement st= con.createStatement();
                    String query="select * from Artist;";
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
