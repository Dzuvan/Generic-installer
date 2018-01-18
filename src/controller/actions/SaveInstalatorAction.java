package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import model.Instalator;
import util.LoadImage;
import util.Serializator;

/**
 * Klasa za čuvanje pojedinačnog instalatora.
 *
 */
@SuppressWarnings("serial")
public class SaveInstalatorAction extends AbstractAction {

    private final String SAVE_INSTALATOR_NAME = MainFrame.getInstance().getResourceBundle().getString("save-instalator-name");
    private final String SAVE_INSTALATOR_DESC = MainFrame.getInstance().getResourceBundle().getString("save-instalator-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public SaveInstalatorAction() {
        putValue(NAME, SAVE_INSTALATOR_NAME);
        putValue(SHORT_DESCRIPTION, SAVE_INSTALATOR_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/save-button.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        if (node instanceof Instalator) {
            Serializator.saveInstalator((Instalator) node);
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("save-instalator-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("save-instalator-desc"));
    }
}
