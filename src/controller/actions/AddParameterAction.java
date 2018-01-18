package controller.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import app.MainFrame;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import model.Instalator;
import model.Parameter;
import model.Wizard;
import model.parameters.SelectInstallerParameter;
import util.LoadImage;
import view.gui.ParameterPanel;

/**
 * Klasa za dodavanje parametra. Nakon što se pozove akcija instancira se panel
 * s parametrima.
 */
@SuppressWarnings("serial")
public class AddParameterAction extends AbstractAction {

    private final String ADD_PARAM_NAME = MainFrame.getInstance().getResourceBundle().getString("add-param-name");
    private final String ADD_PARAM_DESC = MainFrame.getInstance().getResourceBundle().getString("add-param-desc");

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public AddParameterAction() {
        putValue(NAME, ADD_PARAM_NAME);
        putValue(SHORT_DESCRIPTION, ADD_PARAM_DESC);
        putValue(SMALL_ICON, LoadImage.loadIcon("images/settings.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) MainFrame.getInstance().getInstallTree().getLastSelectedPathComponent();
        if (selectedElement instanceof Wizard) {
            Wizard wizard = (Wizard) selectedElement;
            JPanel panel = new JPanel();
            ParameterPanel parameterPanel = MainFrame.getInstance().getParameterPanel();
            parameterPanel.getTxtName().setText("");
            parameterPanel.getRead().setSelected(false);
            parameterPanel.getTypeBox().setSelectedIndex(0);
            parameterPanel.getValuePanel().removeAll();
            Instalator inst = wizard.getInstalator();
            outerloop:
            for (Wizard w : inst.getWizards()) {
                for (Parameter p : w.getParameters()) {
                    if (p instanceof SelectInstallerParameter) {
                        parameterPanel.getTypeBox().removeItemAt(5);
                        break outerloop;
                    }
                }
            }
            panel.add(parameterPanel, BorderLayout.CENTER);
            MainFrame.getInstance().getSp2().setViewportView(panel);
            MainFrame.getInstance().validate();
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("add-param-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("add-param-desc"));
    }
}
