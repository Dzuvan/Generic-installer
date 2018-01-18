package controller.actions;

/**
 * Klasa u kojoj su grupisane sve akcije.
 */
public class ActionManager {

    private AddInstalationAction addInstalationAction;

    private AddWizardAction addWizardAction;
    private EditInstalatorAction editInstalatorAction;
    private DeleteInstalatorAction deleteInstalatorAction;

    private AddParameterAction addParameterAction;
    private EditWizardAction editWizardAction;
    private DeleteWizardAction deleteWizardAction;

    // private TypeComboBoxAction typeComboBoxAction;
    private DeleteParameterAction deleteParameterAction;
    private EditParameterAction editParameterAction;
    private SaveParameterAction saveParameterAction;

    private ImageViewAction imageViewAction;

    private InstallerAction installerAction;
    private PathAction pathAction;

    private AboutAction aboutAction;
    private SaveInstalationAction saveInstalationAction;
    private LoadInstalationAction loadInstalationAction;
    
    private SaveInstalatorAction saveInstalatorAction;
    private LoadInstalatorAction loadInstalatorAction;
    
    private ExitAction exitAction;

    /**
     * Konstruktor klase koji poziva incijalizaciju svih akcija aplikacije.
     */
    public ActionManager() {
        initActions();
    }

    private void initActions() {
        this.addInstalationAction = new AddInstalationAction();
        this.addWizardAction = new AddWizardAction();
        this.deleteInstalatorAction = new DeleteInstalatorAction();
        this.editInstalatorAction = new EditInstalatorAction();
        this.editWizardAction = new EditWizardAction();
        this.deleteWizardAction = new DeleteWizardAction();
        this.addParameterAction = new AddParameterAction();
        this.imageViewAction = new ImageViewAction();
        this.deleteParameterAction = new DeleteParameterAction();
        // this.typeComboBoxAction = new TypeComboBoxAction();
        this.saveParameterAction = new SaveParameterAction();
        this.editParameterAction = new EditParameterAction();
        this.installerAction = new InstallerAction();
        this.pathAction = new PathAction();
        this.aboutAction = new AboutAction();
        this.saveInstalationAction = new SaveInstalationAction();
        this.loadInstalationAction = new LoadInstalationAction();
        this.saveInstalatorAction = new SaveInstalatorAction();
        this.loadInstalatorAction = new LoadInstalatorAction();
        this.exitAction = new ExitAction();
    }

    /**
     *
     * @return
     */
    public AddInstalationAction getAddInstalationAction() {
        return addInstalationAction;
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
    public DeleteInstalatorAction getDeleteInstalatorAction() {
        return deleteInstalatorAction;
    }

    /**
     *
     * @return
     */
    public EditInstalatorAction getEditInstalatorAction() {
        return editInstalatorAction;
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
    public EditWizardAction getEditWizardAction() {
        return editWizardAction;
    }

    /**
     *
     * @return
     */
    public DeleteWizardAction getDeleteWizardAction() {
        return deleteWizardAction;
    }

    /**
     *
     * @return
     */
    public ImageViewAction getImageViewAction() {
        return imageViewAction;
    }

    /**
     *
     * @return
     */
    public DeleteParameterAction getDeleteParameterAction() {
        return deleteParameterAction;
    }
    
    /**
     *
     * @return
     */
    public EditParameterAction getEditParameterAction() {
        return editParameterAction;
    }

    /**
     *
     * @return
     */
    public InstallerAction getInstallerAction() {
        return installerAction;
    }

    /**
     *
     * @return
     */
    public PathAction getPathAction() {
        return pathAction;
    }

    /**
     *
     * @return
     */
    public SaveParameterAction getSaveParameterAction() {
        return saveParameterAction;
    }

    /**
     *
     * @return
     */
    public AboutAction getAboutAction() {
        return aboutAction;
    }

    /**
     *
     * @return
     */
    public SaveInstalationAction getSaveInstalationAction() {
        return saveInstalationAction;
    }

    /**
     *
     * @return
     */
    public LoadInstalationAction getLoadInstalationAction() {
        return loadInstalationAction;
    }

    /**
     *
     * @return
     */
    public SaveInstalatorAction getSaveInstalatorAction() {
        return saveInstalatorAction;
    }

    /**
     *
     * @return
     */
    public LoadInstalatorAction getLoadInstalatorAction() {
        return loadInstalatorAction;
    }

    /**
     *
     * @return
     */
    public ExitAction getExitAction() {
        return exitAction;
    }
    
}
