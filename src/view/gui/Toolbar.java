package view.gui;

import app.MainFrame;
import controller.actions.AddInstalationAction;
import controller.actions.AddParameterAction;
import controller.actions.AddWizardAction;
import controller.actions.DeleteInstalatorAction;
import controller.actions.DeleteParameterAction;
import controller.actions.DeleteWizardAction;
import java.awt.Dimension;
import javax.swing.JToolBar;

/**
 * Toolbar aplikacije.
 */
@SuppressWarnings("serial")
public class Toolbar extends JToolBar {

    private AddInstalationAction addInstallAction;
    private DeleteInstalatorAction deleteInstalatorAction;
    private AddWizardAction addWizardAction;
    private DeleteWizardAction deleteWizarAction;
    private AddParameterAction addParameterAction;
    private DeleteParameterAction deleteParameterAction;

    /**
     * Konstruktor.
     */
    public Toolbar() {
        super();
        initActions();
        add(addInstallAction);
        add(deleteInstalatorAction);
        addSeparator();
        add(addWizardAction);
        add(deleteWizarAction);
        addSeparator();
        add(addParameterAction);
        add(deleteParameterAction);
        addSeparator(new Dimension(250, 0));
        add(MainFrame.getInstance().getActionManager().getSaveParameterAction());
        addSeparator(new Dimension(300, 0));
        add(MainFrame.getInstance().getActionManager().getSaveInstalatorAction());
        add(MainFrame.getInstance().getActionManager().getLoadInstalatorAction());
        add(MainFrame.getInstance().getActionManager().getSaveInstalationAction());
        add(MainFrame.getInstance().getActionManager().getLoadInstalationAction());

    }

    private void initActions() {
        this.addInstallAction = MainFrame.getInstance().getActionManager().getAddInstalationAction();
        this.deleteInstalatorAction = MainFrame.getInstance().getActionManager().getDeleteInstalatorAction();
        this.addWizardAction = MainFrame.getInstance().getActionManager().getAddWizardAction();
        this.deleteWizarAction = MainFrame.getInstance().getActionManager().getDeleteWizardAction();
        this.addParameterAction = MainFrame.getInstance().getActionManager().getAddParameterAction();
        this.deleteParameterAction = MainFrame.getInstance().getActionManager().getDeleteParameterAction();
        
        this.addInstallAction.setEnabled(false);
        this.deleteInstalatorAction.setEnabled(false);
        this.addWizardAction.setEnabled(false);
        this.deleteWizarAction.setEnabled(false);
        this.addParameterAction.setEnabled(false);
        this.deleteParameterAction.setEnabled(false);
    }

    /**
     * Promena jezika.
     */
    public void init() {
        MainFrame.getInstance().getActionManager().getAddInstalationAction().initAction();
        MainFrame.getInstance().getActionManager().getDeleteInstalatorAction().initAction();
        MainFrame.getInstance().getActionManager().getAddWizardAction().initAction();
        MainFrame.getInstance().getActionManager().getDeleteWizardAction().initAction();
        MainFrame.getInstance().getActionManager().getAddParameterAction().initAction();
        MainFrame.getInstance().getActionManager().getDeleteParameterAction().initAction();
        MainFrame.getInstance().getActionManager().getEditInstalatorAction().initAction();
        MainFrame.getInstance().getActionManager().getEditWizardAction().initAction();
        MainFrame.getInstance().getActionManager().getEditParameterAction().initAction();
        MainFrame.getInstance().getActionManager().getImageViewAction().initAction();
        MainFrame.getInstance().getActionManager().getSaveParameterAction().initAction();
        MainFrame.getInstance().getActionManager().getInstallerAction().initAction();
        MainFrame.getInstance().getActionManager().getPathAction().initAction();
        MainFrame.getInstance().getActionManager().getAboutAction().initAction();
        MainFrame.getInstance().getActionManager().getLoadInstalatorAction().initAction();
        MainFrame.getInstance().getActionManager().getSaveInstalatorAction().initAction();
        MainFrame.getInstance().getActionManager().getSaveInstalationAction().initAction();
        MainFrame.getInstance().getActionManager().getLoadInstalationAction().initAction();
        MainFrame.getInstance().getActionManager().getExitAction().initAction();
    }

    /**
     *
     * @return
     */
    public AddInstalationAction getAddInstallAction() {
        return addInstallAction;
    }

    /**
     *
     * @return
     */
    public DeleteInstalatorAction getDeleteInstalatorAction() {
        return deleteInstalatorAction;
    }

    /**
     *
     * @return
     */
    public AddWizardAction getAddWizardAction() {
        return addWizardAction;
    }

    /**
     *
     * @return
     */
    public DeleteWizardAction getDeleteWizarAction() {
        return deleteWizarAction;
    }

    /**
     *
     * @return
     */
    public AddParameterAction getAddParameterAction() {
        return addParameterAction;
    }

    /**
     *
     * @return
     */
    public DeleteParameterAction getDeleteParameterAction() {
        return deleteParameterAction;
    }

}
