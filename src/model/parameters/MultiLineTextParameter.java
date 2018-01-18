package model.parameters;

import model.Parameter;
import model.Wizard;

/**
 * Tip parametra višelinijski tekst.
 */
@SuppressWarnings("serial")
public class MultiLineTextParameter extends Parameter {

    private String multiLineText;
    private boolean isReadOnly;

    /**
     * @param wizard
     * @param name
     * @param type
     * @param multiLineText
     * @param code
     */
    public MultiLineTextParameter(Wizard wizard, String name, String type, String multiLineText, String code) {
        super(name, type, wizard);
        this.multiLineText = multiLineText;
        this.isReadOnly = false;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public MultiLineTextParameter() {
        super();
    }

    /**
     *
     * @return
     */
    public String getMultiLineText() {
        return multiLineText;
    }

    /**
     *
     * @param multiLineText
     */
    public void setMultiLineText(String multiLineText) {
        this.multiLineText = multiLineText;
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
