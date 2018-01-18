package model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 * Klasa koja modeluej stablo instalacije. U sebi sadrži korenski čvor koji je
 * model instalacije.
 */
@SuppressWarnings("serial")
public class InstallTreeModel extends DefaultTreeModel {

    /**
     * Korenski čvor.
     */
    public static Instalation instalator = new Instalation();

    /**
     * Konstruktor.
     */
    public InstallTreeModel() {
        super(instalator);
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof Parameter) {
            return null;
        } else if (parent instanceof Wizard) {
            return ((Wizard) parent).getParameters().get(index);
        } else if (parent instanceof Instalator) {
            return ((Instalator) parent).getWizards().get(index);
        } else if (parent instanceof Instalation) {
            return ((Instalation) parent).getInstalators().get(index);
        }
        return getRoot();
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof Parameter) {
            return 0;
        } else if (parent instanceof Wizard) {
            return ((Wizard) parent).getParameters().size();
        } else if (parent instanceof Instalator) {
            return ((Instalator) parent).getWizards().size();
        } else if (parent instanceof Instalation) {
            return ((Instalation) parent).getInstalators().size();
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return (node instanceof Parameter);
    }

    @Override
    public Instalation getRoot() {
        return instalator;
    }

    @Override
    public void setRoot(TreeNode root) {
        super.setRoot(root);
    }
    
    
}
