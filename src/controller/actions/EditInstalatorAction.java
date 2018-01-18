package controller.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import app.MainFrame;
import javax.swing.tree.TreePath;
import model.Instalation;
import model.Instalator;
import util.LoadImage;
import util.TreeExpander;

/**
 * Klasa za ubacivanje ili izmenu instalatora(ukoliko postoji). Iz stabla se
 * dohvati selektovana komponenta i ako je instalacia(root), onda se doda
 * instalator u stablo, a ako je selektovan instalator pokupi se njegova
 * vrednost iz modela i postavi se vrednost tekstualnog polja.
 */
@SuppressWarnings("serial")
public class EditInstalatorAction extends AbstractAction {

    private final String EDIT_INSTALATOR_NAME = MainFrame.getInstance().getResourceBundle().getString("edit-instalator-name");
    private final String EDIT_INSTALATOR_DESC = MainFrame.getInstance().getResourceBundle().getString("edit-instalator-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public EditInstalatorAction() {
        putValue(NAME, EDIT_INSTALATOR_NAME);
        putValue(SHORT_DESCRIPTION, EDIT_INSTALATOR_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/check.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        JTextField txtNaslov = MainFrame.getInstance().getInstalatorPanel().getTextFieldValue();

        if (selectedElement instanceof Instalation) {
            String naziv = txtNaslov.getText();
            Instalator instalator = new Instalator();
            instalator.setInstalation((Instalation) selectedElement);
            instalator.setName(naziv);

            if (naziv.trim().isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!naziv.trim().isEmpty()) {
                txtNaslov.setText("");
                ((Instalation) selectedElement).addInstalator(instalator);
                MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(instalator));
                TreeExpander.expandTree(instalator);
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            }
        } else if (selectedElement instanceof Instalator) {
            Instalator inst = (Instalator) selectedElement;

            if (!inst.getName().trim().isEmpty()) {
                inst.setName(txtNaslov.getText());
                txtNaslov.setText(inst.getName());
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            }
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("edit-instalator-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("edit-instalator-desc"));
    }
}
