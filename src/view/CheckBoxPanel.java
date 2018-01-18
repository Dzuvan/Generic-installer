package view;

import app.MainFrame;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 * Panel za boolean tip.
 */
@SuppressWarnings("serial")
public class CheckBoxPanel extends JTextField {

    private JLabel lbl;
    private String label;

    /**
     * Podrazumevani konstruktor.
     */
    public CheckBoxPanel() {
    }

    /**
     *
     * @param valuePanel
     * @param label 
     */
    public CheckBoxPanel(JPanel valuePanel) {
        setText("");
        this.label = MainFrame.getInstance().getResourceBundle().getString("cb-label-name");
        this.setName("CheckBox");
        this.setEnabled(true);

        lbl = new JLabel();
        lbl.setText(this.label);
        this.setSize(250, 250);
        this.setEnabled(true);

        valuePanel.setLayout(new MigLayout());
        valuePanel.setSize(350, 350);
        valuePanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.DARK_GRAY));
        valuePanel.add(lbl, "newline, width 250px, center");
        valuePanel.add(this, "newline, width 250px, center");
        valuePanel.revalidate();
    }

    /**
     * Lokalizacija.
     */
    public void changeLanguage() {
        lbl.setText(MainFrame.getInstance().getResourceBundle().getString("cb-label-name"));
    }
}
