package view;

import app.MainFrame;
import controller.tree.InstalTreeEditor;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;

import controller.tree.TreeController;
import javax.swing.tree.TreePath;

/**
 * Stablo.
 */
@SuppressWarnings("serial")
public class InstallTree extends JTree {

    /**
     * @param treeModel
     */
    public InstallTree(TreeModel treeModel) {
        super(treeModel);
        addTreeSelectionListener(new TreeController());
        setCellEditor(new InstalTreeEditor(this, new TreeCellRendered()));
        setCellRenderer(new TreeCellRendered());
        setExpandsSelectedPaths(true);
        setExpandedState(new TreePath(MainFrame.getInstance().getInstallTreeModel().getRoot()), true);
    }
}
