package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import model.Parameter;
import model.Wizard;
import util.LoadImage;

/**
 * Klasa za uklanjanje parametra. Nakon pozivanja akcije ukloni se parametar iz
 * čarobnjaka(ukoliko postoji).
 */
@SuppressWarnings("serial")
public class DeleteParameterAction extends AbstractAction {

    private String DELETE_PARAM_NAME = MainFrame.getInstance().getResourceBundle().getString("delete-param-name");
    private String DELETE_PARAM_DESC = MainFrame.getInstance().getResourceBundle().getString("delete-param-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public DeleteParameterAction() {
        putValue(NAME, DELETE_PARAM_NAME);
        putValue(SHORT_DESCRIPTION, DELETE_PARAM_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/trash-can.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();

        if (selectedElement != null) {
            if (selectedElement instanceof Parameter) {
                Wizard wizard = ((Parameter) selectedElement).getWizard();
                wizard.removeParameter((Parameter) selectedElement);
                MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard.getPath()));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            }
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("delete-param-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("delete-param-desc"));
    }
}
