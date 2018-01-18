package model;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Klasa koja modeluje parametar. Određen je tipom i imenom.
 */
@SuppressWarnings("serial")
public class Parameter extends DefaultMutableTreeNode {

    protected String name;
    protected String type;
    protected transient Wizard wizard;

    /**
     * @param name
     * @param type
     * @param wizard
     */
    public Parameter(String name, String type, Wizard wizard) {
        this.name = name;
        this.type = type;
        this.wizard = wizard;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public Parameter() {
        super();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public Wizard getWizard() {
        return wizard;
    }

    /**
     * @param wizard
     */
    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    @Override
    public String toString() {
        return name;
    }
}
