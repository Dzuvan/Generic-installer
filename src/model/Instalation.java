package model;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Klasa koja modeluje instalaciju. Instalacija predstavlja korenski čvor u
 * stablu i u sebi sadrži niz instalatora.
 */
@SuppressWarnings("serial")
public class Instalation extends DefaultMutableTreeNode {

    private ArrayList<Instalator> instalators = new ArrayList<>();

    @Override
    public String toString() {
        return "Instalation";
    }

    /**
     * @return list of instalators
     */
    public ArrayList<Instalator> getInstalators() {
        return instalators;
    }

    /**
     * @param instalators
     */
    public void setInstalators(ArrayList<Instalator> instalators) {
        this.instalators = instalators;
    }

    /**
     * @param instalator
     */
    public void addInstalator(Instalator instalator) {
        instalators.add(instalator);
    }

    /**
     * @param instalator
     */
    public void removeInstalator(Instalator instalator) {
        instalators.remove(instalator);
    }
}
