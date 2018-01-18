package view.gui;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Klasa koja pedstavlja glavni meni aplikacije.
 *
 */
@SuppressWarnings("serial")
public class Menu extends JMenuBar {

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    private JMenu languageMenu;
    private JCheckBoxMenuItem english;
    private JCheckBoxMenuItem serbian;

    /**
     * Konstruktor menija u koji se smeštaju stavke menija. Stavke menija
     * predstavljau apstraktne akcije koje se dobavljaju preko MainFrame
     * singleton-a.
     */
    public Menu() {
        fileMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("file-menu"));
        fileMenu.setMnemonic(KeyEvent.VK_E);

        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveInstalationAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getLoadInstalationAction());
        fileMenu.addSeparator();
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveInstalatorAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getLoadInstalatorAction());
        fileMenu.addSeparator();
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveParameterAction());
        fileMenu.addSeparator();
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());

        add(fileMenu);

        editMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("edit-menu"));
        editMenu.setMnemonic(KeyEvent.VK_I);

        editMenu.add(MainFrame.getInstance().getActionManager().getAddInstalationAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getDeleteInstalatorAction());
        editMenu.addSeparator();
        editMenu.add(MainFrame.getInstance().getActionManager().getAddWizardAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getDeleteWizardAction());
        editMenu.addSeparator();
        editMenu.add(MainFrame.getInstance().getActionManager().getAddParameterAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getDeleteParameterAction());

        add(editMenu);

        helpMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("help-menu"));
        helpMenu.setMnemonic(KeyEvent.VK_H);

        languageMenu = new JMenu(MainFrame.getInstance().getResourceBundle().getString("language-menu"));
        languageMenu.setMnemonic(KeyEvent.VK_E);

        serbian = new JCheckBoxMenuItem("Serbian");
        serbian.addActionListener((ActionEvent e) -> {
            Locale.setDefault(new Locale("sr", "RS"));
            english.setState(false);
            MainFrame.getInstance().changeLanguge();

        });

        english = new JCheckBoxMenuItem("English");
        english.addActionListener((ActionEvent e) -> {
            Locale.setDefault(new Locale("en", "US"));
            serbian.setState(false);
            MainFrame.getInstance().changeLanguge();

        });

        if (!Locale.getDefault().equals(new Locale("sr","RS"))) {
            english.setState(true);
        } else {
            serbian.setState(true);
        }

        languageMenu.add(serbian);
        languageMenu.add(english);

        add(languageMenu);

        helpMenu.add(MainFrame.getInstance().getActionManager().getAboutAction());
        add(helpMenu);
    }

    /**
     * Promena jezika.
     */
    public void initComponents() {
        editMenu.setText(MainFrame.getInstance().getResourceBundle().getString("edit-menu"));
        fileMenu.setText(MainFrame.getInstance().getResourceBundle().getString("file-menu"));
        helpMenu.setText(MainFrame.getInstance().getResourceBundle().getString("help-menu"));
        languageMenu.setText(MainFrame.getInstance().getResourceBundle().getString("language-menu"));
    }
}
