package controller.actions;

import app.MainFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import model.Parameter;
import model.Wizard;
import model.parameters.CheckBoxParameter;
import model.parameters.ImageParameter;
import model.parameters.MultiLineTextParameter;
import model.parameters.OneLineTextParameter;
import model.parameters.SelectInstallerParameter;
import org.apache.commons.io.FilenameUtils;
import util.LoadImage;
import util.Serializator;
import util.TreeExpander;
import view.gui.WizardPanel;

/**
 * Klasa za izmenu parametra. Na osnovu selektovane stavke padajućeg menija vrši
 * se instanciranje odabranog parametra i povezivanje s adekvatnim panelom.
 */
@SuppressWarnings("serial")
public class EditParameterAction extends AbstractAction {

    private final String EDIT_PARAM_NAME = MainFrame.getInstance().getResourceBundle().getString("edit-param-name");
    private final String EDIT_PARAM_DESC = MainFrame.getInstance().getResourceBundle().getString("edit-param-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public EditParameterAction() {
        putValue(NAME, EDIT_PARAM_NAME);
        putValue(SHORT_DESCRIPTION, EDIT_PARAM_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/check.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        JTextField nameField = MainFrame.getInstance().getParameterPanel().getTxtName();
        JComboBox<String> cb = MainFrame.getInstance().getParameterPanel().getTypeBox();
        JTextField txt = MainFrame.getInstance().getParameterPanel().getOneLineText();
        JTextArea txtArea = MainFrame.getInstance().getParameterPanel().getMultiLineText();
        JTextField checkBoxTxt = MainFrame.getInstance().getParameterPanel().getCheckBox();
        JCheckBox box = MainFrame.getInstance().getParameterPanel().getRead();

        if (selectedElement instanceof Wizard) {
            Wizard wizard = (Wizard) selectedElement;
            String name = nameField.getText();

            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("no-name-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cb.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("no-type-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cb.getSelectedIndex() == 1) {
                OneLineTextParameter param = new OneLineTextParameter();
                param.setWizard(wizard);
                param.setName(name);
                param.setType(cb.getSelectedItem().toString());
                param.setOneLineText(txt.getText().trim());
                param.setIsReadOnly(box.isSelected());
                if (!name.trim().isEmpty()) {
                    wizard.addParameter(param);
                    MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard));
                    TreeExpander.expandTree(param);
                }
            } else if (cb.getSelectedIndex() == 2) {
                MultiLineTextParameter param = new MultiLineTextParameter();
                param.setWizard(wizard);
                param.setName(name);
                param.setType(cb.getSelectedItem().toString());
                param.setMultiLineText(txtArea.getText().trim());
                param.setIsReadOnly(box.isSelected());
                if (!name.trim().isEmpty()) {
                    wizard.addParameter(param);
                    MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard));
                    TreeExpander.expandTree(param);
                }
            } else if (cb.getSelectedIndex() == 3) {
                ImageParameter param = new ImageParameter();
                param.setWizard(wizard);
                param.setName(name);
                param.setType(cb.getSelectedItem().toString());
                param.setUrl(MainFrame.getInstance().getParameterPanel().getImageView().getUrl().getText());
                if (!name.trim().isEmpty()) {
                    wizard.addParameter(param);
                    MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard));
                    TreeExpander.expandTree(param);
                }
            } else if (cb.getSelectedIndex() == 5) {
                SelectInstallerParameter param = new SelectInstallerParameter();
                param.setWizard(wizard);
                param.setName(name);
                param.setType(cb.getSelectedItem().toString());
                param.setDefaultPath(MainFrame.getInstance().getParameterPanel().getSelecteInstaller().getPathUrlField().getText());
                if (!name.trim().isEmpty()) {
                    wizard.addParameter(param);
                    MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard));
                    TreeExpander.expandTree(param);
                }
                File source = new File(MainFrame.getInstance().getParameterPanel().getSelecteInstaller().getInstallerUrlField().getText());

                if (!source.exists()) {
                    JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("no-file-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (param.getDefaultPath().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("no-path-dialog"), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Path p = Paths.get(source.getAbsolutePath());
                String fileName = p.getFileName().toString();
                String s = FilenameUtils.removeExtension(fileName);
                String g = FilenameUtils.removeExtension(s);
                File dest = new File("src" + File.separator + "Rock" + File.separator + g + File.separator);
                if (!dest.exists()) {
                    if (dest.mkdir()) {
                        System.out.println("Directory created!");
                    } else {
                        System.out.println("Failed to create directory");
                    }
                }

                param.setInstallerUrl(dest.getAbsolutePath());
                Serializator.extractFolder(source.getAbsolutePath(), dest.getAbsolutePath());
            } else if (cb.getSelectedIndex() == 4) {
                CheckBoxParameter param = new CheckBoxParameter();
                param.setWizard(wizard);
                param.setName(name);
                param.setType(cb.getSelectedItem().toString());
                param.setText(checkBoxTxt.getText());
                if (!name.trim().isEmpty()) {
                    wizard.addParameter(param);
                    MainFrame.getInstance().getInstallTree().setSelectionPath(new TreePath(wizard));
                    TreeExpander.expandTree(param);
                }
            }

            WizardPanel wp = MainFrame.getInstance().getWizardPanel();
            wp.getTxtName().setText(wizard.getName());
            JPanel panel = new JPanel();
            panel.add(wp, BorderLayout.CENTER);
            MainFrame.getInstance().getSp2().setViewportView(panel);
            MainFrame.getInstance().repaint();

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
            JOptionPane pane = new JOptionPane(MainFrame.getInstance().getResourceBundle().getString("success-param-dialog"));
            final JDialog dialog = pane.createDialog(MainFrame.getInstance().getResourceBundle().getString("success-title"));
            final int DELAY = 1000;
            Timer timer = new Timer(DELAY, (ActionEvent e1) -> {
                dialog.dispose();
            });
            timer.setRepeats(false);
            timer.start();
            dialog.setVisible(true);

        } else if (selectedElement instanceof Parameter) {
            String name = nameField.getText();
            Parameter param = (Parameter) selectedElement;
            param.setName(name);
            Wizard wizard = param.getWizard();
            param.setWizard(wizard);

            if (param.getType().equals("One line text")) {
                OneLineTextParameter p = (OneLineTextParameter) param;
                p.setOneLineText(txt.getText());
                p.setIsReadOnly(box.isSelected());
            } else if (param.getType().equals("Multi line text")) {
                MultiLineTextParameter mp = (MultiLineTextParameter) param;
                mp.setMultiLineText(txtArea.getText());
                mp.setIsReadOnly(box.isSelected());
            } else if (param.getType().equals("Image view")) {
                ImageParameter i = (ImageParameter) param;
                i.setUrl(MainFrame.getInstance().getParameterPanel().getImageView().getUrl().getText());
            } else if (param.getType().equals("Installer and path")) {
                SelectInstallerParameter sip = (SelectInstallerParameter) param;
                sip.setInstallerUrl(MainFrame.getInstance().getParameterPanel().getSelecteInstaller().getInstallerUrlField().getText());
                sip.setDefaultPath(MainFrame.getInstance().getParameterPanel().getSelecteInstaller().getPathUrlField().getText());
            } else if (param.getType().equals("Checkbox")) {
                CheckBoxParameter cbp = (CheckBoxParameter) param;
                cbp.setText(checkBoxTxt.getText());
            }

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getInstallTree());
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("edit-param-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("edit-param-desc"));
    }
}
