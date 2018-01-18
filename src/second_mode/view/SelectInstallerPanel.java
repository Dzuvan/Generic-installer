package second_mode.view;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.parameters.SelectInstallerParameter;

/**
 * Panel za odabir lokacije za instalaciju.
 *
 */
@SuppressWarnings("serial")
public class SelectInstallerPanel extends JPanel {

    private JLabel lbl;
    private JFileChooser jfc;
    public static JTextField pathUrl;
    private JButton btnPath;
    private static String zipURL;
    private static String url;

    /**
     *
     * @param selectParam
     */
    public SelectInstallerPanel(SelectInstallerParameter selectParam) {
        this.lbl = new JLabel(selectParam.getName() + ": ");
        this.jfc = new JFileChooser();
        pathUrl = new JTextField();
        pathUrl.setText(selectParam.getDefaultPath());
        this.btnPath = new JButton("Choose a path: ");
        SelectInstallerPanel.zipURL = selectParam.getInstallerUrl();
        

        btnPath.addActionListener((ActionEvent e) -> {
            jfc.setCurrentDirectory(new File(System.getProperty("user.home")));

            FileFilter pathFile = new FileNameExtensionFilter("SelectPath", ImageIO.getReaderFileSuffixes());
            jfc.setFileFilter(pathFile);
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = jfc.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                pathUrl.setText(selectedFile.getAbsolutePath());
            }
        });

        this.add(lbl);
        this.add(pathUrl);
        this.add(btnPath);
    }

    /**
     *
     * @return
     */
    public JLabel getLbl() {
        return lbl;
    }

    /**
     *
     * @return
     */
    public JFileChooser getJfc() {
        return jfc;
    }

    /**
     *
     * @return
     */
    public static JTextField getPathUrl() {
        return pathUrl;
    }

    /**
     *
     * @return
     */
    public JButton getBtnPath() {
        return btnPath;
    }

    /**
     *
     * @return
     */
    public static String getZipURL() {
        return zipURL;
    }

	/**
	 * @return the url
	 */
	public static String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public static void setUrl(String url) {
		SelectInstallerPanel.url = url;
	}

}
