package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.tree.TreePath;

import controller.actions.ActionManager;
import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.InstallTreeModel;
import util.LoadImage;
import view.gui.InstalatorPanel;
import view.gui.InstalationPanel;
import view.InstallTree;
import view.gui.Menu;
import view.gui.ParameterPanel;
import view.gui.Toolbar;
import view.gui.WizardPanel;

/**
 * Glavan kalsa aplikacije, Singleton je, i u njoj se nalaze reference na sve
 * relevantne klase. Sve ostale klase međusobno komuniciraju posredstvom
 * instance ove klase.
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private InstalationPanel instalationPanel;
    private InstalatorPanel instalatorPanel;
    private WizardPanel wizardPanel;
    private ParameterPanel parameterPanel;
    private JScrollPane sp;
    private JScrollPane sp2;
    private InstallTree installTree;
    private InstallTreeModel installTreeModel;
    private JPanel treePanel;
    private JSplitPane jsp;
    private ResourceBundle resourceBundle;
    private Menu menu;
    private Toolbar toolbar;

    private MainFrame() {

    }

    /**
     * @return singleton instance.
     */
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    /**
     * Metoda koja inicijalizuje look and feel aplikacije, prikaz glavong okvira
     * aplikacije i kreira instance klasa koja se pristupa preko singleton-a.
     */
    private void initialise() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        resourceBundle = ResourceBundle.getBundle("view.gui.MessageResources.MessageResources", Locale.getDefault());
        UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yes-option"));
        UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("no-option"));
        UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("ok-option"));
        UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancel-option"));

        initFrame();
        initComponents();

    }

    private void initFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension size = kit.getScreenSize();
        int width = size.width;
        int height = size.height;
        setSize(4 * width / 5, 4 * height / 5);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 300));
        setTitle(resourceBundle.getString("app-title"));
        setIconImage(LoadImage.loadImage("images/jigsaws.png"));
    }

    private void initComponents() {
        Dimension minimumSize = new Dimension(100, 50);

        installTreeModel = new InstallTreeModel();
        installTree = new InstallTree(installTreeModel);

        this.actionManager = new ActionManager();
        menu = new Menu();
        setJMenuBar(menu);

        toolbar = new Toolbar();
        getContentPane().add(toolbar, BorderLayout.NORTH);
        this.instalationPanel = new InstalationPanel();
        this.instalatorPanel = new InstalatorPanel();
        this.parameterPanel = new ParameterPanel();
        this.wizardPanel = new WizardPanel();

        this.treePanel = new JPanel();
        this.treePanel.setBackground(Color.WHITE);
        this.treePanel.setName("treePanel");

        this.sp = new JScrollPane(this.getInstallTree());
        this.sp.setMinimumSize(minimumSize);

        this.sp2 = new JScrollPane();
        this.sp2.setViewportView(instalationPanel);
        this.sp2.setMinimumSize(minimumSize);

        this.jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, sp2);
        this.jsp.setOneTouchExpandable(true);
        this.jsp.setDividerLocation(150);

        installTree.setSelectionPath(new TreePath(installTreeModel.getRoot()));
        this.add(jsp);

    }

    /**
     * Promena jezika.
     */
    public void changeLanguge() {
        resourceBundle = ResourceBundle.getBundle("view.gui.MessageResources.MessageResources", Locale.getDefault());
        UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yes-option"));
        UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("no-option"));
        UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("ok-option"));
        UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancel-option"));

        setTitle(resourceBundle.getString("app-title"));
        menu.initComponents();
        toolbar.init();
        wizardPanel.changeLanguage();
        parameterPanel.changeLanguage();
        instalatorPanel.changeLanguage();
    }

    /**
     *
     * @return
     */
    public ActionManager getActionManager() {
        return actionManager;
    }

    /**
     *
     * @return
     */
    public InstalationPanel getInstalationPanel() {
        return instalationPanel;
    }

    /**
     *
     * @return
     */
    public InstalatorPanel getInstalatorPanel() {
        return instalatorPanel;
    }

    /**
     *
     * @return
     */
    public WizardPanel getWizardPanel() {
        return wizardPanel;
    }

    /**
     *
     * @return
     */
    public ParameterPanel getParameterPanel() {
        return parameterPanel;
    }

    /**
     *
     * @return
     */
    public JScrollPane getSp() {
        return sp;
    }

    /**
     *
     * @return
     */
    public JScrollPane getSp2() {
        return sp2;
    }

    /**
     *
     * @return
     */
    public InstallTree getInstallTree() {
        return installTree;
    }

    /**
     *
     * @return
     */
    public InstallTreeModel getInstallTreeModel() {
        return installTreeModel;
    }

    /**
     *
     * @return
     */
    public JPanel getTreePanel() {
        return treePanel;
    }

    /**
     *
     * @return
     */
    public JSplitPane getJsp() {
        return jsp;
    }

    /**
     *
     * @return
     */
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    /**
     *
     * @return
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     *
     * @return
     */
    public Toolbar getToolbar() {
        return toolbar;
    }

}
