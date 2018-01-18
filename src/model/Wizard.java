package model;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Klasa koja predstavlja prozor unutar instalera na koji se kače parametri.
 *
 */
@SuppressWarnings("serial")
public class Wizard extends DefaultMutableTreeNode {

    private ArrayList<Parameter> parameters = new ArrayList<>();
    private String name;
    private transient Instalator instalator;

    /**
     * @param name
     * @param instalator
     */
    public Wizard(Instalator instalator, String name) {
        super();
        this.name = name;
        this.instalator = instalator;
    }

    /**
     * Podrazumevani konstruktor.
     */
    public Wizard() {
        super();
    }

    /**
     * @return list of parameters.
     */
    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    /**
     * @param parameters
     */
    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * @param parameter
     */
    public void addParameter(Parameter parameter) {
        this.parameters.add(parameter);
    }

    /**
     * @param parameter
     */
    public void removeParameter(Parameter parameter) {
        int remover = 0;
        for (Parameter p : parameters) {
            if (p.equals(parameter)) {
                remover = 1;
            }
        }
        if (remover == 1) {
            parameters.remove(parameter);
        }
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
     *
     * @return
     */
    public Instalator getInstalator() {
        return instalator;
    }

    /**
     * @param instalator
     */
    public void setInstalator(Instalator instalator) {
        this.instalator = instalator;
    }

    @Override
    public String toString() {
        return name;
    }
}
