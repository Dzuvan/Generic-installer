package controller.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import app.MainFrame;
import javax.swing.tree.TreePath;
import model.Instalator;
import model.Wizard;
import util.LoadImage;
import util.TreeExpander;

/**
 *
 * Klasa za izmenu čarobnjaka. Vrednosti se menjaju na osnovu tekstualnog polja
 * u panelu za čarobnjaka.
 */
@SuppressWarnings("serial")
public class EditWizardAction extends AbstractAction {

    private final String EDIT_WIZARD_NAME = MainFrame.getInstance().getResourceBundle().getString("edit-wizard-name");
    private final String EDIT_WIZARD_DESC = MainFrame.getInstance().getResourceBundle().getString("edit-wizard-desc");

    private JTextField textField;

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public EditWizardAction() {
        putValue(NAME, EDIT_WIZARD_NAME);
        putValue(SHORT_DESCRIPTION, EDIT_WIZARD_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/check.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        textField = MainFrame.getInstance().getWizardPanel().getTxtName();
        if (selectedElement instanceof Instalator) {
            String naziv = textField.getText();
            Wizard wizard = new Wizard();
            wizard.setInstalator((Instalator) selectedElement);

            wizard.setName(naziv);

            if (naziv.trim().isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("no-wiz-name-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!naziv.trim().isEmpty()) {
                textField.setText("");
                ((Instalator) selectedElement).addWizard(wizard);
                MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard));
                TreeExpander.expandTree(wizard);
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());

            }
        } else if (selectedElement instanceof Wizard) {
            Wizard wizard = (Wizard) selectedElement;

            if (!wizard.getName().trim().isEmpty()) {
                wizard.setName(textField.getText());
                textField.setText(wizard.getName());
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            }
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("edit-wizard-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("edit-wizard-desc"));
    }
}
