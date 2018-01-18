package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import app.MainFrame;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import model.Instalator;
import util.LoadImage;

/**
 * Klasa za brisanje instalatora. Nakon poziva akcije se ukloni instalator
 * ukoliko postoji.
 */
@SuppressWarnings("serial")
public class DeleteInstalatorAction extends AbstractAction {

    private final String DELETE_INSTALATOR_NAME = MainFrame.getInstance().getResourceBundle().getString("delete-instalator-name");
    private final String DELETE_INSTALATOR_DESC = MainFrame.getInstance().getResourceBundle().getString("delete-instalator-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public DeleteInstalatorAction() {
        putValue(NAME, DELETE_INSTALATOR_NAME);
        putValue(SHORT_DESCRIPTION, DELETE_INSTALATOR_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/rubbish-bin.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        if (selectedElement != null) {
            if (selectedElement instanceof Instalator) {
                ((Instalator) selectedElement).getInstalation().removeInstalator((Instalator) selectedElement);
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            }
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("delete-instalator-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("delete-instalator-desc"));
    }
}
