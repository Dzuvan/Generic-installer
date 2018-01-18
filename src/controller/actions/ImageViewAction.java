package controller.actions;

import app.MainFrame;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klasa za odabir slike.
 *
 */
@SuppressWarnings("serial")
public class ImageViewAction extends AbstractAction {

    private String IMAGE_NAME = MainFrame.getInstance().getResourceBundle().getString("image-name");
    private String IMAGE_DESC = MainFrame.getInstance().getResourceBundle().getString("image-desc");
    private String IMAGE_EXTENSION = MainFrame.getInstance().getResourceBundle().getString("image-extension");

    private JFileChooser jfc;
    private FileNameExtensionFilter imageFilter;

    /**
     * Konstruktor klase u kom se podešavaju parametri akcije opis, ime,
     * ikonica.
     */
    public ImageViewAction() {
        putValue(NAME, IMAGE_NAME);
        putValue(SHORT_DESCRIPTION, IMAGE_DESC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField urlField = MainFrame.getInstance().getParameterPanel().getImageView().getUrl();
        jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));

        imageFilter = new FileNameExtensionFilter(IMAGE_EXTENSION, ImageIO.getReaderFileSuffixes());
        jfc.setFileFilter(imageFilter);

        int result = jfc.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println("Selected file: " + selectedFile);
            urlField.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Promena jezika.
     */
    public void initAction() {
        putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("image-name"));
        putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("image-desc"));
    }
}
