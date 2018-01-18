package second_mode.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.parameters.MultiLineTextParameter;
import net.miginfocom.swing.MigLayout;

/**
 * Višelinijski tekst panel koji se prikazuje prilikom instalacije.
 */
@SuppressWarnings("serial")
public class MultiLineTextPanel extends JPanel {

    private JLabel lbl = new JLabel();
    private JTextArea txt = new JTextArea();

    /**
     *
     * @param parameter
     */
    public MultiLineTextPanel(MultiLineTextParameter parameter) {
        this.setLayout(new MigLayout());
        this.lbl = new JLabel(parameter.getName() + ": ");
        this.txt = new JTextArea(parameter.getMultiLineText());
        this.txt.setEditable(!parameter.getIsReadOnly());
        this.add(lbl, "newline, split 2, width 30px, center");
        this.add(txt, "wrap, width 150px");
    }
}
