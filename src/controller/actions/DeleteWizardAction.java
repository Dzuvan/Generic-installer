package controller.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import app.MainFrame;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import model.Wizard;
import util.LoadImage;
import view.gui.InstalatorPanel;

/**
 * Klasa za uklanjanje čarobnjaka. Ukoliko čarobnjak postoji, uklanja se i vrši
 * se osvežavanje stabla.
 */
@SuppressWarnings("serial")
public class DeleteWizardAction extends AbstractAction {

    private String DELETE_WIZARD_NAME = MainFrame.getInstance().getResourceBundle().getString("delete-wizard-name");
    private String DELETE_WIZARD_DESC = MainFrame.getInstance().getResourceBundle().getString("delete-wizard-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public DeleteWizardAction() {
        putValue(NAME, DELETE_WIZARD_NAME);
        putValue(SHORT_DESCRIPTION, DELETE_WIZARD_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/delete-button.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();

        if (selectedElement != null) {
            if (selectedElement instanceof Wizard) {
                ((Wizard) selectedElement).getInstalator().removeWizard((Wizard) selectedElement);
                MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(((Wizard) selectedElement).getInstalator()));
                InstalatorPanel in = MainFrame.getInstance().getInstalatorPanel();
                in.getTextFieldValue().setText(((Wizard) selectedElement).getInstalator().getName());
                JPanel panel = new JPanel();
                panel.add(in, BorderLayout.CENTER);
                MainFrame.getInstance().getSp2().setViewportView(panel);
                MainFrame.getInstance().repaint();
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            }
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("delete-wizard-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("delete-wizard-desc"));
    }
}
