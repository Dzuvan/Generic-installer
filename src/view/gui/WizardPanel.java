package view.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.MainFrame;
import net.miginfocom.swing.MigLayout;

/**
 * Panel preko kojeg se dodaju novi parametri.
 */
@SuppressWarnings("serial")
public class WizardPanel extends JPanel {

    private JLabel wizardName;
    private JButton addParameterButton;
    private JButton updateWizardButton;
    private JButton deleteWizardButton;
    private JTextField txtName;

    /**
     * Konstruktor.
     */
    public WizardPanel() {
        this.setLayout(new MigLayout());

        this.wizardName = new JLabel(MainFrame.getInstance().getResourceBundle().getString("wiz-label-name"));
        this.txtName = new JTextField();
        this.addParameterButton = new JButton(MainFrame.getInstance().getActionManager().getAddParameterAction());
        this.updateWizardButton = new JButton(MainFrame.getInstance().getActionManager().getEditWizardAction());
        this.deleteWizardButton = new JButton(MainFrame.getInstance().getActionManager().getDeleteWizardAction());

        add(wizardName, "span, split 2");
        add(txtName, "span, width 400px");
        add(addParameterButton, "split 3, sgx, newline");
        add(deleteWizardButton, "sgx");
        add(updateWizardButton, "sgx");
    }

    /**
     * @return wizard name
     */
    public JLabel getWizardName() {
        return wizardName;
    }

    /**
     * @return add button
     */
    public JButton getAddParameterButton() {
        return addParameterButton;
    }

    /**
     * @return update button
     */
    public JButton getUpdateWizardButton() {
        return updateWizardButton;
    }

    /**
     * @return delete button
     */
    public JButton getDeleteWizardButton() {
        return deleteWizardButton;
    }

    /**
     * @return text name
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * Promena jezika.
     */
    public void changeLanguage() {
        this.wizardName.setText(MainFrame.getInstance().getResourceBundle().getString("wiz-label-name"));
    }
}
