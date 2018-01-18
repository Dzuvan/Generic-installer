package view.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.MainFrame;
import net.miginfocom.swing.MigLayout;

/**
 * Panel u koji se stavlaju čarobnjaci. Sadrži dugmad za brisanje i izmenu.
 *
 */
@SuppressWarnings("serial")
public class InstalatorPanel extends JPanel {

    private JButton addWizardButton;
    private JButton deleteButton;
    private JButton addOrEditButton;
    private JLabel labelName;
    private JTextField textFieldValue;

    /**
     * Podrazumevani konstruktor.
     */
    public InstalatorPanel() {
        this.addWizardButton = new JButton(MainFrame.getInstance().getActionManager().getAddWizardAction());
        this.deleteButton = new JButton(MainFrame.getInstance().getActionManager().getDeleteInstalatorAction());
        this.addOrEditButton = new JButton(MainFrame.getInstance().getActionManager().getEditInstalatorAction());
        this.labelName = new JLabel(MainFrame.getInstance().getResourceBundle().getString("inst-label-name"));
        this.textFieldValue = new JTextField();

        setLayout(new MigLayout());
        add(labelName, "span, split 2 ");
        add(textFieldValue, "span, width 400px");
        add(addWizardButton, "split 3, sgx, newline");
        add(deleteButton, "sgx");
        add(addOrEditButton, "sgx");
    }

    /**
     * Promena jezika.
     */
    public void changeLanguage() {
        this.labelName.setText(MainFrame.getInstance().getResourceBundle().getString("inst-label-name"));
    }

    /**
     *
     * @return
     */
    public JLabel getLabelName() {
        return labelName;
    }

    /**
     *
     * @return
     */
    public JTextField getTextFieldValue() {
        return textFieldValue;
    }

    /**
     *
     * @return
     */
    public JButton getAddWizardButton() {
        return addWizardButton;
    }

    /**
     *
     * @return
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     *
     * @return
     */
    public JButton getAddOrEditButton() {
        return addOrEditButton;
    }
}
