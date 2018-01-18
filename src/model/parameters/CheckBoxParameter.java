package model.parameters;

import model.Parameter;
import model.Wizard;

/**
 * Tip parametra koji može biti true ili false.
 */
@SuppressWarnings("serial")
public class CheckBoxParameter extends Parameter {

    private String text;


    /**
     * @param wizard
     * @param name
     * @param type
     * @param text
     */
    public CheckBoxParameter(Wizard wizard, String name, String type, String text) {
        super(name, type, wizard);
        this.text = text;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public CheckBoxParameter() {
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

}
