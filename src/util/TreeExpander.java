package util;

import app.MainFrame;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * Klasa preko koje se vrši proširenje čvorova u stablu.
 *
 */
public class TreeExpander {

    /**
     * Proširuje čvorove stabla.
     *
     * @param element
     */
    public static void expandTree(DefaultMutableTreeNode element) {
        @SuppressWarnings("unchecked")
        Enumeration<DefaultMutableTreeNode> en = ((DefaultMutableTreeNode) MainFrame.getInstance().getInstallTreeModel().getRoot()).breadthFirstEnumeration();
        JTree tree = MainFrame.getInstance().getInstallTree();
        while (en.hasMoreElements()) {
            DefaultMutableTreeNode curr = en.nextElement();
            MainFrame.getInstance().getInstallTree().scrollPathToVisible(new TreePath(curr.getPath()));
            MainFrame.getInstance().getInstallTree().expandPath(new TreePath(curr.getPath()));
            for (int i = 0; i < tree.getRowCount(); i++) {
                tree.expandRow(i);
            }
        }
    }
}
