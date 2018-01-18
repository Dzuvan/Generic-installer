package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import model.Instalator;
import model.Parameter;
import model.Wizard;
import util.LoadImage;
import util.Serializator;

/**
 *
 * Klasa koja učitava instalatore iz json-a i dodaje u stablo.
 */
@SuppressWarnings("serial")
public class LoadInstalatorAction extends AbstractAction {

    private final String LOAD_INSTALATOR_NAME = MainFrame.getInstance().getResourceBundle().getString("load-instalator-name");
    private final String LOAD_INSTALTOR_DESC = MainFrame.getInstance().getResourceBundle().getString("load-instalator-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public LoadInstalatorAction() {
        putValue(NAME, LOAD_INSTALATOR_NAME);
        putValue(SHORT_DESCRIPTION, LOAD_INSTALTOR_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/open-folder.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Instalator i = Serializator.loadInstalator();

        if (i != null) {
            MainFrame.getInstance().getInstallTreeModel().getRoot().addInstalator(i);
            i.setInstalation(MainFrame.getInstance().getInstallTreeModel().getRoot());

            if (i.getWizards().size() > 0) {
                for (Wizard w : i.getWizards()) {
                    w.setInstalator(i);
                    if (w.getParameters().size() > 0) {
                        for (Parameter p : w.getParameters()) {
                            p.setWizard(w);
                        }
                    }
                }
            }
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
        }
    }

    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("load-instalator-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("load-instalator-desc"));
    }
}
