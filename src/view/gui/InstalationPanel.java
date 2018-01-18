package view.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.MainFrame;

/**
 *
 * Panel u koji se nalaze dugmad za dodavanje instalatora.
 */
@SuppressWarnings("serial")
public class InstalationPanel extends JPanel {

    private JButton addInstalationButton;

    /**
     * Konstruktor.
     */
    public InstalationPanel() {
        super();
        this.addInstalationButton = new JButton(MainFrame.getInstance().getActionManager().getAddInstalationAction());

        this.addInstalationButton.setVisible(true);
        this.addInstalationButton.setEnabled(true);
        this.add(addInstalationButton);
        setName("instalationPanel");
    }
}
