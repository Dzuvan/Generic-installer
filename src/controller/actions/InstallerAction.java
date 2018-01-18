package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klasa za odabir proizvoda za koji se kreira instalacija.
 *
 */
@SuppressWarnings("serial")
public class InstallerAction extends AbstractAction {

    private final String SELECT_NAME = MainFrame.getInstance().getResourceBundle().getString("select-name");
    private final String SELECT_DESC = MainFrame.getInstance().getResourceBundle().getString("select-desc");

    private JFileChooser installerFileChooser;

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public InstallerAction() {
        putValue(NAME, SELECT_NAME);
        putValue(SHORT_DESCRIPTION, SELECT_DESC);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField url = MainFrame.getInstance().getParameterPanel().getSelecteInstaller().getInstallerUrlField();
        installerFileChooser = new JFileChooser();
        installerFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(("Zip files"), "zip");
        installerFileChooser.setAcceptAllFileFilterUsed(false);
        installerFileChooser.setFileFilter(filter);

        int result = installerFileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = installerFileChooser.getSelectedFile();
            System.out.println("Selected file" + selectedFile);
            url.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("select-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("select-desc"));

    }
}
