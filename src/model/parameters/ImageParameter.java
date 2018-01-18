package model.parameters;

import model.Parameter;
import model.Wizard;

/**
 * Tip parametra slika.
 */
@SuppressWarnings("serial")
public class ImageParameter extends Parameter {

    private String url;

    /**
     * @param name
     * @param type
     * @param parent
     * @param url
     */
    public ImageParameter(String name, String type, Wizard parent, String url) {
        super(name, type, parent);
        this.url = url;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public ImageParameter() {
        super();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
