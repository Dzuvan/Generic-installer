package second_mode.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Instalation;
import model.Instalator;
import second_mode.app.SecondFrame;
import util.Serializator;

/**
 *
 * Klasa u kojoj se bira za koji se proizvod vrši instalacija.
 */
@SuppressWarnings("serial")
public class ProductPanel extends JFrame {

    private JComboBox<Object> cb;
    private JButton selectButton;
    private JPanel valuePanel;
    private JButton pickInstalatorButton;

    /**
     * Konstruktor.
     */
    public ProductPanel() {
        initGUI();
        valuePanel = new JPanel();
        cb = new JComboBox<>();
        selectButton = new JButton("Select");
        pickInstalatorButton = new JButton("Pick instalator");
        pickInstalatorButton.addActionListener((ActionEvent e) -> {
            Instalator loadedInstalator = Serializator.loadInstalator();
            cb.addItem(loadedInstalator);
        });
       
                
        Instalation instal = Serializator.serializeFromJson();
        if (instal != null) {
            for (Instalator i : instal.getInstalators()) {
                cb.addItem(i);
            }
        }
        
        selectButton.addActionListener((ActionEvent e) -> {
            Instalator instalator = (Instalator) cb.getSelectedItem();

            if (instalator != null) {
                @SuppressWarnings("unused")
				SecondFrame frame = new SecondFrame(instalator);
                ProductPanel.this.dispose();
            }
        });

        valuePanel.add(cb, BorderLayout.CENTER);
        valuePanel.add(selectButton, BorderLayout.SOUTH);
        valuePanel.add(pickInstalatorButton, BorderLayout.SOUTH);
        add(valuePanel);
    }

    private void initGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Pick product");
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
