package util;

import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Klasa za učitavanje slika i ikonica.
 *
 */
public class LoadImage {

    /**
     * @param fileName
     * @return icon
     */
    public static Icon loadIcon(String fileName) {
        URL imageURL = LoadImage.class.getClassLoader().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        } else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }

    /**
     * @param fileName
     * @return image
     */
    public static Image loadImage(String fileName) {
        URL imageURL = LoadImage.class.getClassLoader().getResource(fileName);
        Image image = null;

        if (imageURL != null) {
            image = new ImageIcon(imageURL).getImage();
        } else {
            System.err.println("Resource not found: " + fileName);
        }
        return image;
    }
}
