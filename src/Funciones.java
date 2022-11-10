import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Funciones extends JFrame {
    private JPanel panel;
    private JTree FuncionesArbol;
    private JTextArea txtDescripcion;
    private JButton btnCrear;
    private JButton btnMenu;

    public Funciones() {
        setContentPane(panel);
        this.setSize(800, 550);

        FuncionesArbol.setBounds(0, 0, 250, 550);
        txtDescripcion.setBounds(250, 0, 230, 550);
        btnCrear.setBounds(410, 200, 100, 100);

        DefaultMutableTreeNode SysFunctions = new DefaultMutableTreeNode("System Functions");

        DefaultMutableTreeNode AF = new DefaultMutableTreeNode("Agreggate Functions");
        DefaultMutableTreeNode CoF = new DefaultMutableTreeNode("Configuration Functions");
        DefaultMutableTreeNode CuF = new DefaultMutableTreeNode("Cursor Functions");
        DefaultMutableTreeNode DTF = new DefaultMutableTreeNode("Date and Time Functions");
        DefaultMutableTreeNode MathF = new DefaultMutableTreeNode("Mathematical Functions");
        DefaultMutableTreeNode MetaF = new DefaultMutableTreeNode("Metadata Functions");
        DefaultMutableTreeNode OF = new DefaultMutableTreeNode("Other Functions");
        DefaultMutableTreeNode HIF = new DefaultMutableTreeNode("Hierarchy Id Functions");
        DefaultMutableTreeNode RF = new DefaultMutableTreeNode("Rowset Functions");
        DefaultMutableTreeNode SecF = new DefaultMutableTreeNode("Security Functions");
        DefaultMutableTreeNode StrF = new DefaultMutableTreeNode("String Functions");
        DefaultMutableTreeNode SSF = new DefaultMutableTreeNode("System Statistical Functions");
        DefaultMutableTreeNode TIF = new DefaultMutableTreeNode("Text and Image Functions");

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

        ArrayList<String> afArrayD = new ArrayList<>();
        ArrayList<String> cofArrayD = new ArrayList<>();
        ArrayList<String> cufArrayD = new ArrayList<>();
        ArrayList<String> dtfArrayD = new ArrayList<>();
        ArrayList<String> mathfArrayD = new ArrayList<>();
        ArrayList<String> metafArrayD = new ArrayList<>();
        ArrayList<String> ofArrayD = new ArrayList<>();
        ArrayList<String> hifArrayD = new ArrayList<>();
        ArrayList<String> rfArrayD = new ArrayList<>();
        ArrayList<String> secfArrayD = new ArrayList<>();
        ArrayList<String> strfArrayD = new ArrayList<>();
        ArrayList<String> ssfArrayD = new ArrayList<>();
        ArrayList<String> tifArrayD = new ArrayList<>();

        SysFunctions.add(AF);
        try {
            ArrayList<String> afArray = new ArrayList<>();

            java.io.File fileAF = new java.io.File("src//FunctionFiles//AF.txt");
            java.io.File fileAF2 = new java.io.File("src//FunctionFiles//AF2.txt");
            java.io.File fileAF3 = new java.io.File("src//FunctionFiles//AF_Desc.txt");

            Scanner primero = new Scanner(fileAF);
            Scanner segundo = new Scanner(fileAF2);
            Scanner tercero = new Scanner(fileAF3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PAF.add(node);
            }

            while (segundo.hasNext()) {
                afArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                afArrayD.add(tercero.next());
            }

            for (int i = 0; i < PAF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PAF.getChildAt(i);
                String[] parts = afArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(CoF);
        try {
            ArrayList<String> cofArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//CoF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//CoF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//CoF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PCoF.add(node);
            }

            while (segundo.hasNext()) {
                cofArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                cofArrayD.add(tercero.next());
            }

            for (int i = 0; i < PCoF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PCoF.getChildAt(i);
                String[] parts = cofArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(CuF);
        try {
            ArrayList<String> cufArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//CuF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//CuF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//CuF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PCuF.add(node);
            }

            while (segundo.hasNext()) {
                cufArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                cufArrayD.add(tercero.next());
            }

            for (int i = 0; i < PCuF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PCuF.getChildAt(i);
                String[] parts = cufArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(DTF);
        try {
            ArrayList<String> dtfArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//DTF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//DTF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//DTF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PDTF.add(node);
            }

            while (segundo.hasNext()) {
                dtfArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                dtfArrayD.add(tercero.next());
            }

            for (int i = 0; i < PDTF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PDTF.getChildAt(i);
                String[] parts = dtfArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(MathF);
        try {
            ArrayList<String> mathfArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//MathF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//MathF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//MathF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PMathF.add(node);
            }

            while (segundo.hasNext()) {
                mathfArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                mathfArrayD.add(tercero.next());
            }

            for (int i = 0; i < PMathF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PMathF.getChildAt(i);
                String[] parts = mathfArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(MetaF);
        try {
            ArrayList<String> metafArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//MetaF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//MetaF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//MetaF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PMetaF.add(node);
            }

            while (segundo.hasNext()) {
                metafArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                metafArrayD.add(tercero.next());
            }

            for (int i = 0; i < PMetaF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PMetaF.getChildAt(i);
                String[] parts = metafArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(OF);
        try {
            ArrayList<String> ofArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//OF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//OF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//OF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                POF.add(node);
            }

            while (segundo.hasNext()) {
                ofArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                ofArrayD.add(tercero.next());
            }

            for (int i = 0; i < POF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) POF.getChildAt(i);
                String[] parts = ofArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(HIF);
        try {
            ArrayList<String> hifArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//HIF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//HIF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//HIF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PHIF.add(node);
            }

            while (segundo.hasNext()) {
                hifArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                hifArrayD.add(tercero.next());
            }

            for (int i = 0; i < PHIF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PHIF.getChildAt(i);
                String[] parts = hifArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(RF);
        try {
            ArrayList<String> rfArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//RF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//RF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//RF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PRF.add(node);
            }

            while (segundo.hasNext()) {
                rfArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                rfArrayD.add(tercero.next());
            }

            for (int i = 0; i < PRF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PRF.getChildAt(i);
                String[] parts = rfArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(SecF);
        try {
            ArrayList<String> secfArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//SecF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//SecF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//SecF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PSecF.add(node);
            }

            while (segundo.hasNext()) {
                secfArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                secfArrayD.add(tercero.next());
            }

            for (int i = 0; i < PSecF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PSecF.getChildAt(i);
                String[] parts = secfArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(StrF);
        try {
            ArrayList<String> strfArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//StrF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//StrF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//StrF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PStrF.add(node);
            }

            while (segundo.hasNext()) {
                strfArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                strfArrayD.add(tercero.next());
            }

            for (int i = 0; i < PStrF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PStrF.getChildAt(i);
                String[] parts = strfArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(SSF);
        try {
            ArrayList<String> ssfArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//SSF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//SSF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//SSF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PSSF.add(node);
            }

            while (segundo.hasNext()) {
                ssfArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                ssfArrayD.add(tercero.next());
            }

            for (int i = 0; i < PSSF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PSSF.getChildAt(i);
                String[] parts = ssfArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        SysFunctions.add(TIF);
        try {
            ArrayList<String> tifArray = new ArrayList<>();

            java.io.File file = new java.io.File("src//FunctionFiles//TIF.txt");
            java.io.File file2 = new java.io.File("src//FunctionFiles//TIF2.txt");
            java.io.File file3 = new java.io.File("src//FunctionFiles//TIF_Desc.txt");

            Scanner primero = new Scanner(file);
            Scanner segundo = new Scanner(file2);
            Scanner tercero = new Scanner(file3);

            primero.useDelimiter(";");
            segundo.useDelimiter("#");
            tercero.useDelimiter(";");

            while (primero.hasNext()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(primero.next());
                PTIF.add(node);
            }

            while (segundo.hasNext()) {
                tifArray.add(segundo.next());
            }

            while (tercero.hasNext()) {
                tifArrayD.add(tercero.next());
            }

            for (int i = 0; i < PTIF.getChildCount(); i++) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) PTIF.getChildAt(i);
                String[] parts = tifArray.get(i).split(";");

                for (int j = 0; j < parts.length; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(parts[j]);
                    root.add(node);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        DefaultTreeModel model = new DefaultTreeModel(SysFunctions);
        FuncionesArbol.setModel(model);

        FuncionesArbol.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FuncionesArbol.getLastSelectedPathComponent();

                int i = selectedNode.getParent().getIndex(selectedNode);

                if(selectedNode.getParent().getParent().toString().equals("Agreggate Functions")) {
                    txtDescripcion.setText(afArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Configuration Functions")) {
                    txtDescripcion.setText(cofArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Cursor Functions")) {
                    txtDescripcion.setText(cufArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Date and Time Functions")) {
                    txtDescripcion.setText(dtfArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Mathematical Functions")) {
                    txtDescripcion.setText(mathfArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Metadata Functions")) {
                    txtDescripcion.setText(metafArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Other Functions")) {
                    txtDescripcion.setText(ofArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Hierarchy Id Functions")) {
                    txtDescripcion.setText(hifArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Rowset Functions")) {
                    txtDescripcion.setText(rfArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Security Functions")) {
                    txtDescripcion.setText(secfArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("String Functions")) {
                    txtDescripcion.setText(strfArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("System Statistical Functions")) {
                    txtDescripcion.setText(ssfArrayD.get(i));
                }
                else if(selectedNode.getParent().getParent().toString().equals("Text and Image Functions")) {
                    txtDescripcion.setText(tifArrayD.get(i));
                }
                else {
                    txtDescripcion.setText("Descripcion...");
                }
            }
        });

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new CrearFuncion();
                frame.setBounds(300, 70, 700, 700);
                frame.setVisible(true);
            }
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrlConexion url = new UrlConexion();
                JFrame frame = new Menu(url.getUser(), url.getPass());
                frame.setBounds(300, 100, 700, 500);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
