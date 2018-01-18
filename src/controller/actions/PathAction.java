package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klasa za odabir putanje.
 *
 */
@SuppressWarnings("serial")
public class PathAction extends AbstractAction {

    private String PATH_NAME = MainFrame.getInstance().getResourceBundle().getString("path-name");
    private String PATH_DESC = MainFrame.getInstance().getResourceBundle().getString("path-desc");

    private JFileChooser pathFileChooser;

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public PathAction() {
        putValue(NAME, PATH_NAME);
        putValue(SHORT_DESCRIPTION, PATH_DESC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField pathUrl = MainFrame.getInstance().getParameterPanel().getSelecteInstaller().getPathUrlField();
        pathFileChooser = new JFileChooser();
        pathFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileFilter pathFilter = new FileNameExtensionFilter(PATH_DESC, ImageIO.getReaderFileSuffixes());
        pathFileChooser.setFileFilter(pathFilter);
        pathFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = pathFileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = pathFileChooser.getSelectedFile();
            System.out.println("Selcted path:" + selectedFile.getAbsolutePath());
            pathUrl.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("path-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("path-desc"));
    }
}
