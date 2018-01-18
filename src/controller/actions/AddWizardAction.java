package controller.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import app.MainFrame;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import model.Instalator;
import util.LoadImage;
import view.gui.WizardPanel;

/**
 * Klasa za dodavanje čarobnjaka. U selektovani instalator se dodaje panel za
 * kreiranje čarobnjaka.
 */
@SuppressWarnings("serial")
public class AddWizardAction extends AbstractAction {

    private final String ADD_WIZARD_NAME = MainFrame.getInstance().getResourceBundle().getString("add-wizard-name");
    private final String ADD_WIZARD_DESC = MainFrame.getInstance().getResourceBundle().getString("add-wizard-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public AddWizardAction() {
        putValue(NAME, ADD_WIZARD_NAME);
        putValue(SHORT_DESCRIPTION, ADD_WIZARD_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/wand.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selected = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        if (selected instanceof Instalator) {
            JPanel panel = new JPanel();
            WizardPanel wp = MainFrame.getInstance().getWizardPanel();
            wp.getTxtName().setText("");
            wp.getAddParameterButton().setEnabled(false);
            wp.getDeleteWizardButton().setEnabled(false);
            panel.add(wp, BorderLayout.CENTER);
            MainFrame.getInstance().getSp2().setViewportView(panel);
            MainFrame.getInstance().validate();
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("add-wizard-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("add-wizard-desc"));
    }
}
