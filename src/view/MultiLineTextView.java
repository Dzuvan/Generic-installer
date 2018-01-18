package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.MainFrame;
import net.miginfocom.swing.MigLayout;

/**
 * Višelinijski tekst.
 */
@SuppressWarnings("serial")
public class MultiLineTextView extends JTextArea {

    private JLabel lbl;
    private String label;

    /**
     * Podrazumevani konstruktor.
     */
    public MultiLineTextView() {
    }

    /**
     *
     * @param valuePanel
     */
    public MultiLineTextView(JPanel valuePanel) {
        setText("");
        lbl = new JLabel();
        this.label = MainFrame.getInstance().getResourceBundle().getString("multi-label-name");
        lbl.setText(this.label);

        this.setName("textArea");
        this.setMaximumSize(new Dimension(200, 200));
        this.setMinimumSize(new Dimension(150, 150));

        valuePanel.setLayout(new MigLayout());
        valuePanel.setSize(350, 350);
        valuePanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.DARK_GRAY));
        valuePanel.add(lbl, "newline, width 150px, center");
        valuePanel.add(this, "newline, width 200px, center");
        valuePanel.revalidate();
    }

    /**
     * Promena jezika.
     */
    public void changeLanguage() {
        this.lbl.setText(MainFrame.getInstance().getResourceBundle().getString("multi-label-name"));
    }
}
