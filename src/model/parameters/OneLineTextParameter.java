package model.parameters;

import model.Parameter;
import model.Wizard;

/**
 * Tip parametra jednolinijski tekst.
 */
@SuppressWarnings("serial")
public class OneLineTextParameter extends Parameter {

    private String oneLineText;
    private boolean isReadOnly;

    /**
     * @param wizard
     * @param name
     * @param type
     * @param oneLineText
     */
    public OneLineTextParameter(Wizard wizard, String name, String type, String oneLineText) {
        super(name, type, wizard);
        this.oneLineText = oneLineText;
        this.isReadOnly = false;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public OneLineTextParameter() {
        super();
    }

    /**
     * @return
     */
    public String getOneLineText() {
        return oneLineText;
    }

    /**
     * @param oneLineText
     */
    public void setOneLineText(String oneLineText) {
        this.oneLineText = oneLineText;
    }

    /**
     *
     * @return
     */
    public boolean getIsReadOnly() {
        return isReadOnly;
    }

    /**
     *
     * @param isReadOnly
     */
    public void setIsReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }
    
    
}
