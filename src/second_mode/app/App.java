package second_mode.app;

import javax.swing.SwingUtilities;
import second_mode.view.ProductPanel;

/**
 * Ulazna tačka u drugi režim rada.
 */
public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            @SuppressWarnings("unused")
			ProductPanel pp = new ProductPanel();
        });
    }
}
