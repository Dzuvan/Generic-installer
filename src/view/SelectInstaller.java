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
 * Panel za odabir proizvoda.
 */
@SuppressWarnings("serial")
public class SelectInstaller extends JPanel {

    private JTextField installerUrlField;
    private JTextField pathUrlField;
    private JButton installerButton;
    private JButton pathButton;

    /**
     * Podrazumevani konstruktor.
     */
    public SelectInstaller() {
    }

    /**
     *
     * @param valuePanel
     */
    public SelectInstaller(JPanel valuePanel) {
        valuePanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.DARK_GRAY));
        installerUrlField = new JTextField();
        installerUrlField.setText("");
        pathUrlField = new JTextField();
        pathUrlField.setText("");
        installerButton = new JButton(MainFrame.getInstance().getActionManager().getInstallerAction());
        pathButton = new JButton(MainFrame.getInstance().getActionManager().getPathAction());

        setLayout(new MigLayout());
        add(installerUrlField, "newline, split 2, wrap, width 350px");
        add(installerButton, "right");
        add(pathUrlField, "newline, split 2, center, wrap, width 350px");
        add(pathButton, "right");
        setMaximumSize(new Dimension(500, 500));
        valuePanel.add(this, BorderLayout.CENTER);
        valuePanel.revalidate();
    }

    /**
     *
     * @return
     */
    public JTextField getInstallerUrlField() {
        return installerUrlField;
    }

    /**
     *
     * @return
     */
    public JTextField getPathUrlField() {
        return pathUrlField;
    }

    /**
     *
     * @return
     */
    public JButton getInstallerButton() {
        return installerButton;
    }

    /**
     *
     * @return
     */
    public JButton getPathButton() {
        return pathButton;
    }

}
