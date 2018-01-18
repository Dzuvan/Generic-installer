package second_mode.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.parameters.ImageParameter;

/**
 * Panel u kojem se nalazi slika prilkom instalacije.
 */
@SuppressWarnings("serial")
public class ImageViewPanel extends JPanel {

    private BufferedImage image;
    private JLabel lbl;

    /**
     *
     * @param imageParameter
     */
    public ImageViewPanel(ImageParameter imageParameter) {
        try {
            this.image = ImageIO.read(new File(imageParameter.getUrl()));
        } catch (IOException e) {
        }

        this.lbl = new JLabel(new ImageIcon(image));

        add(lbl);
    }
}
