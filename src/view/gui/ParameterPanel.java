package view.gui;

import app.MainFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import view.CheckBoxPanel;
import view.ImagePanel;
import view.MultiLineTextView;
import view.OneLineTextView;
import view.SelectInstaller;

/**
 * Panel koji sadrži padajući meni za izbor parametra. Nakon što se izabere
 * parametar u donjem delu se instancira novi panel preko kojeg se unose
 * vrednosti vezane za konkretan parametar.
 */
@SuppressWarnings("serial")
public class ParameterPanel extends JPanel {

    private ImagePanel imageView;
    private OneLineTextView oneLineText;
    private MultiLineTextView multiLineText;
    private SelectInstaller selecteInstaller;
    private CheckBoxPanel checkBox;
    private JLabel name;
    private JLabel type;
    private JTextField txtName;
    private JComboBox<String> typeBox;
    private JPanel valuePanel;
    private JButton editButton;
    private JButton deleteButton;
    private JButton saveConfigurationButton;
    private JCheckBox read;
    private JLabel readOnly;

    /**
     * Konstruktor.
     */
    public ParameterPanel() {
        super();
        name = new JLabel(MainFrame.getInstance().getResourceBundle().getString("param-label-name"));
        type = new JLabel(MainFrame.getInstance().getResourceBundle().getString("param-label-type"));
        txtName = new JTextField();
        typeBox = new JComboBox<>();
        valuePanel = new JPanel();
        read = new JCheckBox();
        readOnly = new JLabel(MainFrame.getInstance().getResourceBundle().getString("read-only"));
        valuePanel.setLayout(new MigLayout());
        valuePanel.setName("param panel");

        typeBox.addItem("");
        typeBox.addItem("One line text");
        typeBox.addItem("Multi line text");
        typeBox.addItem("Image view");
        typeBox.addItem("Checkbox");

        typeBox.addItem("Installer and path");

        setLayout(new MigLayout());
        add(name, "split 2, sgx, newline");
        add(txtName, "span, width 200px");
        add(readOnly, "split 2, sgx, newline");
        add(read, "center");
        add(type, "split 2, sgx, newline");
        add(typeBox, "width 200px");
        add(valuePanel, "newline");

        typeBox.addActionListener((ActionEvent e) -> {
            @SuppressWarnings("unchecked")
            JComboBox<String> cb = (JComboBox<String>) e.getSource();
            String tp = (String) cb.getSelectedItem();
            if (tp.trim().equals("One line text")) {
                removeComponents(valuePanel);
                oneLineText = new OneLineTextView(valuePanel);
            } else if (tp.trim().equals("Multi line text")) {
                removeComponents(valuePanel);
                multiLineText = new MultiLineTextView(valuePanel);
            } else if (tp.trim().equals("Image view")) {
                removeComponents(valuePanel);
                imageView = new ImagePanel(valuePanel);
            } else if (tp.trim().equals("Installer and path")) {
                removeComponents(valuePanel);
                selecteInstaller = new SelectInstaller(valuePanel);
            } else if (tp.trim().equals("Checkbox")) {
                removeComponents(valuePanel);
                checkBox = new CheckBoxPanel(valuePanel);
            }
        });
        editButton = new JButton(MainFrame.getInstance().getActionManager().getEditParameterAction());
        deleteButton = new JButton(MainFrame.getInstance().getActionManager().getDeleteParameterAction());
        saveConfigurationButton = new JButton(MainFrame.getInstance().getActionManager().getSaveParameterAction());

        add(editButton, "split 2, sgx, newline, right");
        add(deleteButton, "sgx, right");
        add(saveConfigurationButton, "newline, sgx, right, bottom");
    }

    /**
     * Promena jezika.
     */
    public void changeLanguage() {
        this.name.setText(MainFrame.getInstance().getResourceBundle().getString("param-label-name"));
        this.type.setText(MainFrame.getInstance().getResourceBundle().getString("param-label-type"));
        this.readOnly.setText(MainFrame.getInstance().getResourceBundle().getString("read-only"));

        if (this.oneLineText != null) {
            oneLineText.changeLanguage();
        }
        if (this.multiLineText != null) {
            multiLineText.changeLanguage();
        }
        if (this.checkBox != null) {
            checkBox.changeLanguage();
        }
    }

    /**
     *
     * @return
     */
    public ImagePanel getImageView() {
        return imageView;
    }

    /**
     *
     * @param imageView
     */
    public void setImageView(ImagePanel imageView) {
        this.imageView = imageView;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     *
     * @param txtName
     */
    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getTypeBox() {
        return typeBox;
    }

    /**
     *
     * @param typeBox
     */
    public void setTypeBox(JComboBox<String> typeBox) {
        this.typeBox = typeBox;
    }

    /**
     *
     * @return
     */
    public JPanel getValuePanel() {
        return valuePanel;
    }

    /**
     *
     * @param valuePanel
     */
    public void setValuePanel(JPanel valuePanel) {
        this.valuePanel = valuePanel;
    }

    /**
     *
     * @return
     */
    public OneLineTextView getOneLineText() {
        return oneLineText;
    }

    /**
     *
     * @param oneLineText
     */
    public void setOneLineText(OneLineTextView oneLineText) {
        this.oneLineText = oneLineText;
    }

    /**
     *
     * @return
     */
    public MultiLineTextView getMultiLineText() {
        return multiLineText;
    }

    /**
     *
     * @param multiLineText
     */
    public void setMultiLineText(MultiLineTextView multiLineText) {
        this.multiLineText = multiLineText;
    }

    /**
     *
     * @return
     */
    public SelectInstaller getSelecteInstaller() {
        return selecteInstaller;
    }

    /**
     *
     * @param selecteInstaller
     */
    public void setSelecteInstaller(SelectInstaller selecteInstaller) {
        this.selecteInstaller = selecteInstaller;
    }

    /**
     *
     * @return
     */
    public CheckBoxPanel getCheckBox() {
        return checkBox;
    }

    /**
     *
     * @param checkBox
     */
    public void setCheckBox(CheckBoxPanel checkBox) {
        this.checkBox = checkBox;
    }

    /**
     *
     * @return
     */
    public JCheckBox getRead() {
        return read;
    }

    /**
     *
     * @param read
     */
    public void setRead(JCheckBox read) {
        this.read = read;
    }

    /**
     * Ukalanja sve komponente sa panela.
     *
     * @param panel
     */
    public void removeComponents(JPanel panel) {
        if (panel.getComponentCount() != 0) {
            for (Component component : panel.getComponents()) {
                panel.remove(component);
                panel.revalidate();
                panel.repaint();
            }
        }
    }
}
