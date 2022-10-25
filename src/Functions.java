import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Functions extends JFrame{
    private JPanel panel;
    private JTree FuncionesArbol;
    private JTextArea txtDescripcion;


    public Functions() {
        setContentPane(panel);
        this.setSize(500, 550);

        FuncionesArbol.setBounds(0, 0, 250, 550);

        DefaultMutableTreeNode SysFunctions = new DefaultMutableTreeNode("System Functions");

        DefaultMutableTreeNode AF = new DefaultMutableTreeNode("Agregate Fuctions");
        DefaultMutableTreeNode CF = new DefaultMutableTreeNode("Configuration Fuctions");

        SysFunctions.add(AF);
        SysFunctions.add(CF);

        DefaultMutableTreeNode AF1 = new DefaultMutableTreeNode("Avg()");
        DefaultMutableTreeNode AF2 = new DefaultMutableTreeNode("Count()");
        DefaultMutableTreeNode AF3 = new DefaultMutableTreeNode("Max()");
        DefaultMutableTreeNode AF4 = new DefaultMutableTreeNode("Min()");

        AF.add(AF1);
        AF.add(AF2);
        AF.add(AF3);
        AF.add(AF4);

        DefaultMutableTreeNode CF1 = new DefaultMutableTreeNode("ConnectionProperty()");
        DefaultMutableTreeNode CF2 = new DefaultMutableTreeNode("@@Datefirst");
        DefaultMutableTreeNode CF3 = new DefaultMutableTreeNode("@@Dbts");

        CF.add(CF1);
        CF.add(CF2);
        CF.add(CF3);

        DefaultTreeModel model = new DefaultTreeModel(SysFunctions);
        FuncionesArbol.setModel(model);

        this.add(FuncionesArbol);
        this.add(txtDescripcion);
    }

}
