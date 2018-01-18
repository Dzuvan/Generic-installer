package view;

import app.MainFrame;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 * Jednolinijski tekst.
 */
@SuppressWarnings("serial")
public class OneLineTextView extends JTextField {

    private JLabel lbl;
    private String label;

    /**
     * Podrazumevani konstruktor.
     */
    public OneLineTextView() {

    }

    /**
     *
     * @param valuePanel
     */
    public OneLineTextView(JPanel valuePanel) {
        setText("");
        lbl = new JLabel();
        this.label = MainFrame.getInstance().getResourceBundle().getString("multi-label-name");

        lbl.setText(this.label);

        this.setSize(250, 250);
        this.setName("One line text");
        this.setEnabled(true);

        valuePanel.setLayout(new MigLayout());
        valuePanel.setSize(250, 350);
        valuePanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.DARK_GRAY));
        valuePanel.add(lbl, "newline, width 250px, center");
        valuePanel.add(this, "newline, width 250px, center");
        valuePanel.setName("one line text panel");
        valuePanel.revalidate();
    }

    /**
     * Promena jezika.
     */
    public void changeLanguage() {
        this.lbl.setText(MainFrame.getInstance().getResourceBundle().getString("multi-label-name"));
    }

}
