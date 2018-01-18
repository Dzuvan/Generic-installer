package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import util.LoadImage;

/**
 *
 * Akcija za izlazak iz aplikacije.
 */
@SuppressWarnings("serial")
public class ExitAction extends AbstractAction {

    private final String EXIT_NAME = MainFrame.getInstance().getResourceBundle().getString("exit-name");
    private final String EXIT_DESC = MainFrame.getInstance().getResourceBundle().getString("exit-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public ExitAction() {
        putValue(NAME, EXIT_NAME);
        putValue(SHORT_DESCRIPTION, EXIT_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/logout.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("exit-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("exit-desc"));
    }
}
