package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import util.LoadImage;
import util.Serializator;

/**
 * Klasa koja čuva celokupno stablo.
 *
 */
@SuppressWarnings("serial")
public class SaveInstalationAction extends AbstractAction {

    private final String SAVE_NAME = MainFrame.getInstance().getResourceBundle().getString("save-name");
    private final String SAVE_DESC = MainFrame.getInstance().getResourceBundle().getString("save-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public SaveInstalationAction() {
        putValue(NAME, SAVE_NAME);
        putValue(SHORT_DESCRIPTION, SAVE_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/save.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Serializator.save(MainFrame.getInstance().getInstallTreeModel().getRoot());
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("save-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("save-desc"));
    }
}
