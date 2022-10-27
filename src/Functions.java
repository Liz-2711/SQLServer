import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions extends JFrame{
    private JPanel panel;
    private JTree FuncionesArbol;
    private JTextArea txtDescripcion;


    public Functions() {
        setContentPane(panel);
        this.setSize(500, 550);

        FuncionesArbol.setBounds(0, 0, 250, 550);
        txtDescripcion.setBounds(250, 0, 250, 550);

        DefaultMutableTreeNode SysFunctions = new DefaultMutableTreeNode("System Functions");

        DefaultMutableTreeNode AF = new DefaultMutableTreeNode("Agregate Fuctions");
        DefaultMutableTreeNode CoF = new DefaultMutableTreeNode("Configuration Fuctions");
        DefaultMutableTreeNode CuF = new DefaultMutableTreeNode("Cursor Functions");
        DefaultMutableTreeNode DTF = new DefaultMutableTreeNode("Date and Time Fuctions");
        DefaultMutableTreeNode MathF = new DefaultMutableTreeNode("Mathematical Fuctions");
        DefaultMutableTreeNode MetaF = new DefaultMutableTreeNode("Metadata Fuctions");
        DefaultMutableTreeNode OF = new DefaultMutableTreeNode("Other Fuctions");
        DefaultMutableTreeNode HIF = new DefaultMutableTreeNode("Hierarchy Id Fuctions");
        DefaultMutableTreeNode RF = new DefaultMutableTreeNode("Rowset Fuctions");
        DefaultMutableTreeNode SecF = new DefaultMutableTreeNode("Security Fuctions");
        DefaultMutableTreeNode StrF = new DefaultMutableTreeNode("String Fuctions");
        DefaultMutableTreeNode SSF = new DefaultMutableTreeNode("System Statistical Fuctions");
        DefaultMutableTreeNode TIF = new DefaultMutableTreeNode("Text and Image Fuctions");

        DefaultMutableTreeNode PAF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PCoF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PCuF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PDTF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PMathF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PMetaF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode POF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PHIF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PRF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PSecF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PStrF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PSSF = new DefaultMutableTreeNode("Parameters");
        DefaultMutableTreeNode PTIF = new DefaultMutableTreeNode("Parameters");

        AF.add(PAF);
        CoF.add(PCoF);
        CuF.add(PCuF);
        DTF.add(PDTF);
        MathF.add(PMathF);
        MetaF.add(PMetaF);
        OF.add(POF);
        HIF.add(PHIF);
        RF.add(PRF);
        SecF.add(PSecF);
        StrF.add(PStrF);
        SSF.add(PSSF);
        TIF.add(PTIF);

        SysFunctions.add(AF);
        ArrayList<String> afArray = new ArrayList<>();
        java.io.File fileAF = new java.io.File("src//test.txt");
        try {
            Scanner input = new Scanner(fileAF);
            Scanner newline = new Scanner(fileAF);
            Scanner primero = new Scanner(fileAF);
            input.useDelimiter(";");
            newline.useDelimiter(".");
            primero.useDelimiter("#");

            /*
            * DefaultMutableTreeNode node = new DefaultMutableTreeNode();
                node.setUserObject(element);*/

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PAF.add(node);
                while (input.hasNext()) {
                    DefaultMutableTreeNode n = new DefaultMutableTreeNode(input.next());
                    node.add(n);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(CoF);
        SysFunctions.add(CuF);
        SysFunctions.add(DTF);
        SysFunctions.add(MathF);
        SysFunctions.add(MetaF);
        SysFunctions.add(OF);
        SysFunctions.add(HIF);
        SysFunctions.add(RF);
        SysFunctions.add(SecF);
        SysFunctions.add(StrF);
        SysFunctions.add(SSF);
        SysFunctions.add(TIF);

        DefaultTreeModel model = new DefaultTreeModel(SysFunctions);
        FuncionesArbol.setModel(model);

    }

}
