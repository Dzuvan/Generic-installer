package model;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Klasa koja modeluje instalator. Instalator u sebi sadrži niz
 * prozora(wizarda).
 */
@SuppressWarnings("serial")
public class Instalator extends DefaultMutableTreeNode {

    private String name;
    private ArrayList<Wizard> wizards = new ArrayList<>();
    private transient Instalation instalation;

    /**
     * @param name
     * @param instalation
     */
    public Instalator(Instalation instalation, String name) {
        super();
        this.name = name;
        this.instalation = instalation;
    }

    /**
     * Podrazumevani konstruktor
     */
    public Instalator() {
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
     * @return list of wizards
     */
    public ArrayList<Wizard> getWizards() {
        return wizards;
    }

    /**
     * @param wizards
     */
    public void setWizards(ArrayList<Wizard> wizards) {
        this.wizards = wizards;
    }

    /**
     * @param wizard
     */
    public void addWizard(Wizard wizard) {
        this.wizards.add(wizard);
    }

    /**
     * @param wizard
     */
    public void removeWizard(Wizard wizard) {
        int a = 0;
        for (Wizard w : wizards) {
            if (w.equals(wizard)) {
                a = 1;
            }
        }
        if (a == 1) {
            this.wizards.remove(wizard);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * @return installation
     */
    public Instalation getInstalation() {
        return instalation;
    }

    /**
     * @param instalation
     */
    public void setInstalation(Instalation instalation) {
        this.instalation = instalation;
    }
}
