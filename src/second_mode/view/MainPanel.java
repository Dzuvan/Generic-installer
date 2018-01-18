package second_mode.view;

import javax.swing.JPanel;
import model.Wizard;
import model.parameters.CheckBoxParameter;
import model.parameters.ImageParameter;
import model.parameters.MultiLineTextParameter;
import model.parameters.OneLineTextParameter;
import model.parameters.SelectInstallerParameter;
import net.miginfocom.swing.MigLayout;

/**
 * Glavni panel u kojem se instanciraju parametarski paneli u zavisnosti od
 * parametara koji su nakačeni na čarobnjaka.
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {

    private final Wizard wizard;
    private CheckBoxPanel checkboxView;

    /**
     *
     * @param wizard
     */
    public MainPanel(Wizard wizard) {
        super();
        this.setLayout(new MigLayout());
        this.wizard = wizard;

        initGUI();
    }

    private void initGUI() {
        wizard.getParameters().forEach((param) -> {
            if (param instanceof OneLineTextParameter) {
                OneLineTextParameter oneLineText = (OneLineTextParameter) param;
                OneLineTextPanel oneLineView = new OneLineTextPanel(oneLineText);

                add(oneLineView, "newline, center");

            } else if (param instanceof MultiLineTextParameter) {
                MultiLineTextParameter multiLineText = (MultiLineTextParameter) param;
                MultiLineTextPanel multiLineView = new MultiLineTextPanel(multiLineText);

                add(multiLineView, "newline, center");

            } else if (param instanceof ImageParameter) {
                ImageParameter imageParam = (ImageParameter) param;
                ImageViewPanel imageView = new ImageViewPanel(imageParam);

                add(imageView, "newline, center");

            } else if (param instanceof CheckBoxParameter) {
                CheckBoxParameter checkbox = (CheckBoxParameter) param;
                checkboxView = new CheckBoxPanel(checkbox);

                add(checkboxView, "newline, center");
            } else if (param instanceof SelectInstallerParameter) {
                SelectInstallerParameter selectParameter = (SelectInstallerParameter) param;
                SelectInstallerPanel selectView = new SelectInstallerPanel(selectParameter);

                add(selectView, "newline, center");
            }
        });
        this.revalidate();
        this.repaint();
    }

    /**
     * @return
     */
    public CheckBoxPanel getCheckboxView() {
        return checkboxView;
    }

    /**
     * @param checkboxView
     */
    public void setCheckboxView(CheckBoxPanel checkboxView) {
        this.checkboxView = checkboxView;
    }

}
