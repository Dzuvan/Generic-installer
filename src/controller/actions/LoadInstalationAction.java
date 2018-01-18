package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import model.Instalation;
import model.Instalator;
import model.Parameter;
import model.Wizard;
import util.LoadImage;
import util.Serializator;

/**
 * Klasa za učitavanje radnog prostora.
 */
@SuppressWarnings("serial")
public class LoadInstalationAction extends AbstractAction {

    private final String LOAD_INSTALATION_NAME = MainFrame.getInstance().getResourceBundle().getString("load-instalation-name");
    private final String LOAD_INSTALATION_DESC = MainFrame.getInstance().getResourceBundle().getString("load-instalation-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public LoadInstalationAction() {
        putValue(NAME, LOAD_INSTALATION_NAME);
        putValue(SHORT_DESCRIPTION, LOAD_INSTALATION_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/open.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Instalation instal = Serializator.load();
        Instalation root = MainFrame.getInstance().getInstallTreeModel().getRoot();

        if (instal != null) {
            if (instal.getInstalators().size() > 0) {
                root.setInstalators(instal.getInstalators());
                for (Instalator i : instal.getInstalators()) {
                    i.setInstalation(root);
                    System.out.println(i.getName());
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
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("load-instalation-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("load-instalation-desc"));
    }
}
