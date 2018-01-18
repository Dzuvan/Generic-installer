package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * Klasa koja prikazuje dijalog o programu.
 */
@SuppressWarnings("serial")
public class AboutAction extends AbstractAction {

    private String ABOUT_NAME = MainFrame.getInstance().getResourceBundle().getString("about-name");
    private String ABOUT_DESC = MainFrame.getInstance().getResourceBundle().getString("about-desc");

    /**
     * Konstruktor.
     */
    public AboutAction() {
        putValue(NAME, ABOUT_NAME);
        putValue(SHORT_DESCRIPTION, ABOUT_DESC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = MainFrame.getInstance().getResourceBundle().getString("about-text-1") + "\n";
        text += MainFrame.getInstance().getResourceBundle().getString("about-text-2") + "\n";
        text += MainFrame.getInstance().getResourceBundle().getString("about-text-3") + "\n";

        JOptionPane.showMessageDialog(MainFrame.getInstance(), text, MainFrame.getInstance().getResourceBundle().getString("about-name"),
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("about-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("about-desc"));
    }

}
