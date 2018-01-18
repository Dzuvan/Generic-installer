package controller.tree;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import app.MainFrame;
import model.Instalation;
import model.Instalator;
import model.Parameter;
import model.Wizard;
import model.parameters.CheckBoxParameter;
import model.parameters.ImageParameter;
import model.parameters.MultiLineTextParameter;
import model.parameters.OneLineTextParameter;
import model.parameters.SelectInstallerParameter;
import view.gui.InstalationPanel;
import view.gui.InstalatorPanel;
import view.gui.ParameterPanel;
import view.gui.WizardPanel;

/**
 * Klasa koja osluškuje selekciju u stablu. Nakon što se izvrši selekcija, u
 * zavisnoti od selektovane instance, instanciraju se paneli vezani za
 * selektovanu instancu i popunjavaju se vrednostima iz modela.
 *
 */
public class TreeController implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object target = e.getPath().getLastPathComponent();

        if (target instanceof Instalation) {

            MainFrame.getInstance().getToolbar().getAddInstallAction().setEnabled(true);
            MainFrame.getInstance().getToolbar().getAddWizardAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getDeleteWizarAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getAddParameterAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getDeleteParameterAction().setEnabled(false);

            InstalationPanel inst = new InstalationPanel();
            MainFrame.getInstance().getSp2().setViewportView(inst);
            MainFrame.getInstance().repaint();

        } else if (target instanceof Instalator) {

            InstalatorPanel instalatorPanel = MainFrame.getInstance().getInstalatorPanel();
            Instalator inst = (Instalator) target;

            instalatorPanel.getDeleteButton().setEnabled(true);
            instalatorPanel.getAddWizardButton().setEnabled(true);

            MainFrame.getInstance().getToolbar().getDeleteInstalatorAction().setEnabled(true);
            MainFrame.getInstance().getToolbar().getAddWizardAction().setEnabled(true);
            MainFrame.getInstance().getToolbar().getAddInstallAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getDeleteWizarAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getAddParameterAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getDeleteParameterAction().setEnabled(false);

            String text = inst.getName();
            instalatorPanel.getTextFieldValue().setText(text);
            JPanel panel = new JPanel();
            panel.add(instalatorPanel, BorderLayout.CENTER);
            MainFrame.getInstance().getSp2().setViewportView(panel);
            MainFrame.getInstance().repaint();

        } else if (target instanceof Wizard) {

            Wizard wizard = (Wizard) target;
            String text = wizard.getName();
            WizardPanel wizardPanel = MainFrame.getInstance().getWizardPanel();

            wizardPanel.getAddParameterButton().setEnabled(true);
            wizardPanel.getDeleteWizardButton().setEnabled(true);

            MainFrame.getInstance().getToolbar().getAddParameterAction().setEnabled(true);
            MainFrame.getInstance().getToolbar().getDeleteWizarAction().setEnabled(true);
            MainFrame.getInstance().getToolbar().getDeleteInstalatorAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getDeleteParameterAction().setEnabled(false);

            wizardPanel.getTxtName().setText(text);
            JPanel panel = new JPanel();
            panel.add(wizardPanel, BorderLayout.CENTER);
            MainFrame.getInstance().getSp2().setViewportView(panel);
            MainFrame.getInstance().repaint();

        } else if (target instanceof Parameter) {
            MainFrame.getInstance().getToolbar().getDeleteParameterAction().setEnabled(true);
            MainFrame.getInstance().getToolbar().getAddWizardAction().setEnabled(false);
            MainFrame.getInstance().getToolbar().getDeleteWizarAction().setEnabled(false);

            if (((Parameter) target).getType().equals("One line text")) {

                OneLineTextParameter oneLineTextParam = new OneLineTextParameter();
                Wizard w = ((Parameter) target).getWizard();
                for (Parameter param : w.getParameters()) {
                    if (param.getName().equals(((Parameter) target).getName())) {
                        oneLineTextParam = (OneLineTextParameter) param;
                    }
                }
                JPanel panel = new JPanel();
                ParameterPanel parameterPanel = new ParameterPanel();
                parameterPanel.getTxtName().setText(oneLineTextParam.getName());
                parameterPanel.getTypeBox().setSelectedItem(oneLineTextParam.getType());
                parameterPanel.getTypeBox().setEnabled(false);
                parameterPanel.getOneLineText().setText(oneLineTextParam.getOneLineText());
                parameterPanel.getRead().setSelected(oneLineTextParam.getIsReadOnly());
                panel.add(parameterPanel, BorderLayout.CENTER);
                MainFrame.getInstance().getSp2().setViewportView(parameterPanel);
                MainFrame.getInstance().validate();
            } else if (((Parameter) target).getType().equals("Multi line text")) {

                MultiLineTextParameter multiLineTextParam = new MultiLineTextParameter();
                Wizard w = ((Parameter) target).getWizard();
                for (Parameter param : w.getParameters()) {
                    if (param.getName().equals(((Parameter) target).getName())) {
                        multiLineTextParam = (MultiLineTextParameter) param;
                    }
                }

                JPanel panel = new JPanel();
                ParameterPanel parameterPanel = new ParameterPanel();
                parameterPanel.getTxtName().setText(multiLineTextParam.getName());
                parameterPanel.getTypeBox().setSelectedItem(multiLineTextParam.getType());
                parameterPanel.getTypeBox().setEnabled(false);
                parameterPanel.getMultiLineText().setText(multiLineTextParam.getMultiLineText());
                parameterPanel.getRead().setSelected(multiLineTextParam.getIsReadOnly());
                panel.add(parameterPanel, BorderLayout.CENTER);
                MainFrame.getInstance().getSp2().setViewportView(parameterPanel);
                MainFrame.getInstance().validate();
            } else if (((Parameter) target).getType().equals("Image view")) {

                JPanel panel = new JPanel();
                ParameterPanel parameterPanel = new ParameterPanel();
                ImageParameter imageParam = new ImageParameter();
                Wizard w = ((Parameter) target).getWizard();
                for (Parameter param : w.getParameters()) {
                    if (param.getName().equals(((Parameter) target).getName())) {
                        imageParam = (ImageParameter) param;
                    }
                }

                parameterPanel.getTxtName().setText(imageParam.getName());
                parameterPanel.getTypeBox().setSelectedItem(imageParam.getType());
                parameterPanel.getTypeBox().setEnabled(false);
                parameterPanel.getImageView().getUrl().setText(imageParam.getUrl());
                panel.add(parameterPanel, BorderLayout.CENTER);
                MainFrame.getInstance().getSp2().setViewportView(panel);
                MainFrame.getInstance().validate();
            } else if (((Parameter) target).getType().equals("Installer and path")) {

                JPanel panel = new JPanel();
                ParameterPanel parameterPanel = new ParameterPanel();
                SelectInstallerParameter selectInstallerPanel = new SelectInstallerParameter();
                Wizard w = ((Parameter) target).getWizard();
                for (Parameter param : w.getParameters()) {
                    if (param.getName().equals(((Parameter) target).getName())) {
                        selectInstallerPanel = (SelectInstallerParameter) param;
                    }
                }
                parameterPanel.getTxtName().setText(selectInstallerPanel.getName());
                parameterPanel.getTypeBox().setSelectedItem(selectInstallerPanel.getType());
                parameterPanel.getTypeBox().setEnabled(false);
                parameterPanel.getSelecteInstaller().getInstallerUrlField().setText(selectInstallerPanel.getInstallerUrl());
                parameterPanel.getSelecteInstaller().getPathUrlField().setText(selectInstallerPanel.getDefaultPath());
                panel.add(parameterPanel, BorderLayout.CENTER);
                MainFrame.getInstance().getSp2().setViewportView(panel);
                MainFrame.getInstance().validate();
            } else if (((Parameter) target).getType().equals("Checkbox")) {

                JPanel panel = new JPanel();
                ParameterPanel parameterPanel = new ParameterPanel();
                CheckBoxParameter checkBoxParam = new CheckBoxParameter();
                Wizard w = ((Parameter) target).getWizard();
                for (Parameter param : w.getParameters()) {
                    if (param.getName().equals(((Parameter) target).getName())) {
                        checkBoxParam = (CheckBoxParameter) param;
                    }
                }
                parameterPanel.getTxtName().setText(checkBoxParam.getName());
                parameterPanel.getTypeBox().setSelectedItem(checkBoxParam.getType());
                parameterPanel.getTypeBox().setEnabled(false);
                parameterPanel.getCheckBox().setText(checkBoxParam.getText());
                panel.add(parameterPanel, BorderLayout.CENTER);
                MainFrame.getInstance().getSp2().setViewportView(parameterPanel);
                MainFrame.getInstance().validate();
            }
        }
    }
}
