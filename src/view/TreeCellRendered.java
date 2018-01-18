package view;

import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import model.Instalation;
import model.Instalator;
import model.Parameter;
import model.Wizard;
import util.LoadImage;

/**
 * Klasa za prikaz čovorova preko ikonica u stablu.
 */
@SuppressWarnings("serial")
public class TreeCellRendered extends DefaultTreeCellRenderer {

    /**
     * Podrazumevani konstruktor.
     */
    public TreeCellRendered() {
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof Instalation) {
            setIcon(LoadImage.loadIcon("images/root.png"));
            setToolTipText(((Instalation) value).toString());
        } else if (value instanceof Instalator) {
            setIcon(LoadImage.loadIcon("images/instalator.png"));
            setToolTipText(((Instalator) value).getName());
        } else if (value instanceof Wizard) {
            setIcon(LoadImage.loadIcon("images/magic-wand.png"));
            setToolTipText(((Wizard) value).getName());
        } else if (value instanceof Parameter) {
            setIcon(LoadImage.loadIcon("images/parameters.png"));
            setToolTipText(((Parameter) value).getName());
        }

        return this;
    }
}
