package view;

import app.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 * Panel za sliku.
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

    private JTextField url;
    private JButton chooseButton;

    /**
     * Konstruktor.
     */
    public ImagePanel() {

    }

    /**
     * @param valuePanel
     */
    public ImagePanel(JPanel valuePanel) {
        url = new JTextField();
        url.setText("");
        chooseButton = new JButton(MainFrame.getInstance().getActionManager().getImageViewAction());

        setLayout(new MigLayout());

        this.add(url, "newline, split 2, center, wrap, width 350px");
        this.add(chooseButton, "right");
        this.setMaximumSize(new Dimension(350, 100));

        valuePanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.DARK_GRAY));
        valuePanel.add(this, BorderLayout.CENTER);
        valuePanel.revalidate();
    }

    /**
     * @return url converted to string
     */
    public String getImageUrl() {
        return url.getText();
    }

    /**
     * @return url from text field
     */
    public JTextField getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(JTextField url) {
        this.url = url;
    }
}
