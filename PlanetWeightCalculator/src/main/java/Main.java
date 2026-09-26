import controller.CalculatorController;
import model.PlanetWeightModel;
import view.MainFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanetWeightModel model = new PlanetWeightModel();
            MainFrame view = new MainFrame();
            model.addObserver(view);
            CalculatorController controller = new CalculatorController(model, view);
            view.setController(controller);
            view.setVisible(true);
        });
    }
}