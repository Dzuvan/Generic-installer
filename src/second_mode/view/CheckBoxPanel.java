package second_mode.view;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import model.parameters.CheckBoxParameter;
import net.miginfocom.swing.MigLayout;

/**
 * Panel s true / false poljem u instalaciji.
 * 
 */
@SuppressWarnings("serial")
public class CheckBoxPanel extends JPanel {
    
    private JCheckBox check;
    
    /**
     *
     * @param checkboxParam
     */
    public CheckBoxPanel(CheckBoxParameter checkboxParam) {
        this.setLayout(new MigLayout());
        check = new JCheckBox(checkboxParam.getText());
        add(check,"newline, sgx");
    }
    
    /**
     * @return
     */
    public JCheckBox getCheck() {
        return check;
    }
    
    /**
     * @param check
     */
    public void setCheck(JCheckBox check) {
        this.check = check;
    }
    
}
