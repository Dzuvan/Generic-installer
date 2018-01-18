package second_mode.app;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import model.Instalator;
import second_mode.view.MainPanel;
import second_mode.view.NavigationPanel;

/**
 * Glavni okvir druge aplikacije.
 */
@SuppressWarnings("serial")
public class SecondFrame extends JFrame {

    private Instalator model;
    private MainPanel mainPanel;
    private JScrollPane jsp;

    /**
     *
     * @param model
     */
    public SecondFrame(Instalator model) {
        super();
        this.model = model;

        initGUI();
    }

    private void initGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        jsp = new JScrollPane();
        setLayout(new BorderLayout());
        try {
            mainPanel = new MainPanel(model.getWizards().get(0));
            jsp.setViewportView(mainPanel);
        } catch (Exception e) {
        }
        add(jsp);

        add(new NavigationPanel(model.getWizards().size(), this), BorderLayout.SOUTH);

        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instalation");
        setVisible(true);
        setLocationRelativeTo(null);

    }

    /**
     * @return
     */
    public Instalator getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(Instalator model) {
        this.model = model;
    }

    /**
     * @return
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * @param mainPanel
     */
    public void setMainPanel(MainPanel mainPanel) {
        remove(this.mainPanel);

        this.mainPanel = mainPanel;
        add(this.mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * @return
     */
    public JScrollPane getJsp() {
        return jsp;
    }

    /**
     * @param jsp
     */
    public void setJsp(JScrollPane jsp) {
        this.jsp = jsp;
    }

}
