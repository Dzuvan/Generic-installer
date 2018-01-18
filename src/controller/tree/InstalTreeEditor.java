package controller.tree;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Parameter;
import model.Wizard;

/**
 * Klasa za izmenu polja u stablu.
 *
 */
public class InstalTreeEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object item = null;
    private JTextField edit = null;

    /**
     * @param arg0
     * @param arg1
     */
    public InstalTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @return text field
     */
    public Component getTreeCellEditorComponent(JTree arg0, DefaultTreeCellRenderer arg1) {
        item = arg0;
        edit = new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    @Override
    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent) {
            if (((MouseEvent) arg0).getClickCount() == 3) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (item instanceof Wizard) {
            ((Wizard) item).setName(e.getActionCommand());
        } else if (item instanceof Parameter) {
            ((Parameter) item).setName(e.getActionCommand());
        }
    }
}
