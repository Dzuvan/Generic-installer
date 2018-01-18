//package controller.actions;
//
//import app.MainFrame;
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import javax.swing.AbstractAction;
//import javax.swing.JComboBox;
//import javax.swing.JPanel;
//import view.CheckBoxPanel;
//import view.ImagePanel;
//import view.MultiLineTextView;
//import view.OneLineTextView;
//import view.SelectInstaller;
//
///**
// * Klasa koja prikazuje panel u zavisnoti od izbora u padajućem meniju.
// *
// */
//@SuppressWarnings("serial")
//public class TypeComboBoxAction extends AbstractAction {
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void actionPerformed(ActionEvent e) {
//        JComboBox<String> cb = (JComboBox<String>) e.getSource();
//        String type = (String) cb.getSelectedItem();
//        JPanel valuePanel = MainFrame.getInstance().getParameterPanel().getValuePanel();
//
//        switch (type.trim()) {
//            case "One line text":
//                removeComponents(valuePanel);
//                MainFrame.getInstance().getParameterPanel().setOneLineText(new OneLineTextView(valuePanel));
//                break;
//            case "Multi line text":
//                removeComponents(valuePanel);
//                MainFrame.getInstance().getParameterPanel().setMultiLineText(new MultiLineTextView(valuePanel));
//                break;
//            case "Image view":
//                removeComponents(valuePanel);
//                MainFrame.getInstance().getParameterPanel().setImageView(new ImagePanel(valuePanel));
//                break;
//            case "Installer and path":
//                removeComponents(valuePanel);
//                MainFrame.getInstance().getParameterPanel().setSelecteInstaller(new SelectInstaller(valuePanel));
//                break;
//            case "Checkbox":
//                removeComponents(valuePanel);
//                MainFrame.getInstance().getParameterPanel().setCheckBox(new CheckBoxPanel(valuePanel));
//                break;
//            default:
//                break;
//        }
//    }
//
//    /**
//     * Ukalanja sve komponente sa panela.
//     *
//     * @param panel
//     */
//    public void removeComponents(JPanel panel) {
//        if (panel.getComponentCount() != 0) {
//            for (Component component : panel.getComponents()) {
//                panel.remove(component);
//                panel.revalidate();
//                panel.repaint();
//            }
//        }
//    }
//}
