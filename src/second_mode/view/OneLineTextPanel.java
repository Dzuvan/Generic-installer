package second_mode.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.parameters.OneLineTextParameter;
import net.miginfocom.swing.MigLayout;

/**
 * Jednolinijski tekst panel koji se prikazuje prilikom instalacije.
 */
@SuppressWarnings("serial")
public class OneLineTextPanel extends JPanel {

    private JLabel lbl;
    private JTextField txt;

    /**
     *
     * @param parameter
     */
    public OneLineTextPanel(OneLineTextParameter parameter) {
        setLayout(new MigLayout());
        this.lbl = new JLabel(parameter.getName() + " : ");
        this.txt = new JTextField(parameter.getOneLineText());
        this.txt.setEditable(!parameter.getIsReadOnly());

        add(lbl, "newline, center, split 2");
        add(txt, "width 150px");
    }
}
