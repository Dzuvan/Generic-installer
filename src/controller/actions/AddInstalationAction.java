package controller.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import app.MainFrame;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import util.LoadImage;
import view.gui.InstalatorPanel;

/**
 * Akcija koja kreina instalaciju koja predstavlja korenski čvor u stablu.
 * Pozivom akcije se instacira panel instalatora u koji se stavljau wizardi.
 */
@SuppressWarnings("serial")
public class AddInstalationAction extends AbstractAction {

    private final String ADD_INST_NAME = MainFrame.getInstance().getResourceBundle().getString("add-inst-name");
    private final String ADD_INST_DESC = MainFrame.getInstance().getResourceBundle().getString("add-inst-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public AddInstalationAction() {
        putValue(NAME, ADD_INST_NAME);
        putValue(SHORT_DESCRIPTION, ADD_INST_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/install.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel panel = new JPanel();
        InstalatorPanel inst = MainFrame.getInstance().getInstalatorPanel();
        inst.getDeleteButton().setEnabled(false);
        inst.getAddWizardButton().setEnabled(false);
        inst.getTextFieldValue().setText("");
        panel.add(inst, BorderLayout.CENTER);
        MainFrame.getInstance().getSp2().setViewportView(panel);
        MainFrame.getInstance().validate();
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("add-inst-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("add-inst-desc"));
    }
}
