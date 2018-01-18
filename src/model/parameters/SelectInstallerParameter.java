package model.parameters;

import model.Parameter;
import model.Wizard;

/**
 * Tip parametra prozivod i putanja.
 *
 */
@SuppressWarnings("serial")
public class SelectInstallerParameter extends Parameter {

    private String installerUrl;
    private String defaultPath;

    /**
     * @param wizard
     * @param name
     * @param type
     * @param url
     * @param defaultPath
     */
    public SelectInstallerParameter(Wizard wizard, String name, String type, String url, String defaultPath) {
        super(name, type, wizard);
        this.installerUrl = url;
        this.defaultPath = defaultPath;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public SelectInstallerParameter() {
        super();
    }

    /**
     * @return
     */
    public String getInstallerUrl() {
        return installerUrl;
    }

    /**
     * @param installerUrl
     */
    public void setInstallerUrl(String installerUrl) {
        this.installerUrl = installerUrl;
    }

    /**
     * @return
     */
    public String getDefaultPath() {
        return defaultPath;
    }

    /**
     * @param defaultPath
     */
    public void setDefaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
    }
}
