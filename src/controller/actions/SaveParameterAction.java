package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Instalation;
import model.Instalator;
import model.Parameter;
import model.Wizard;
import util.LoadImage;
import util.Serializator;

/**
 * Klasa koja poziva serijalizaciju u json.
 */
@SuppressWarnings("serial")
public class SaveParameterAction extends AbstractAction {

    private String SAVE_NAME = MainFrame.getInstance().getResourceBundle().getString("export-name");
    private String SAVE_DESC = MainFrame.getInstance().getResourceBundle().getString("export-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public SaveParameterAction() {
        putValue(NAME, SAVE_NAME);
        putValue(SHORT_DESCRIPTION, SAVE_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/puzzle.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Instalation root = (Instalation) MainFrame.getInstance().getInstallTreeModel().getRoot();
        int n = 0;
        for (Instalator i : root.getInstalators()) {
            for (Wizard w : i.getWizards()) {
                for (Parameter p : w.getParameters()) {
                    if (p.getType().equals("Installer and path")) {
                        n++;
                    }
                }
            }
        }
        if (n == 0) {
            System.out.println(n);
            JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("no-inst-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Serializing");
            Serializator.serializeToJson(MainFrame.getInstance().getInstallTreeModel().getRoot());

        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("export-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("export-desc"));

    }
}
