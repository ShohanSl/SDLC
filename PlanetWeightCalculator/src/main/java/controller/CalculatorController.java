package controller;

import model.PlanetWeightModel;
import view.InputDialog;
import view.MainFrame;

public class CalculatorController {
    private final PlanetWeightModel model;
    private final MainFrame view;

    public CalculatorController(PlanetWeightModel model, MainFrame view) {
        this.model = model;
        this.view = view;
    }

    public void onInputDataRequested() {
        InputDialog dialog = new InputDialog(view, view.getLastEnteredWeight());
        dialog.setVisible(true);

        if (!dialog.isConfirmed()) {
            return;
        }

        String rawInput = dialog.getInputText();

        try {
            if (rawInput.isEmpty()) {
                throw new IllegalArgumentException("Поле веса не может быть пустым!");
            }

            double weight = Double.parseDouble(rawInput.replace(',', '.'));

            if (weight <= 0 || weight > 1000) {
                throw new IllegalArgumentException("Вес должен быть положительным числом (от 0.1 до 1000 кг)!");
            }

            model.calculatePlanetaryWeights(weight);

        } catch (NumberFormatException ex) {
            view.showError("Некорректный формат числа! Введите число, например: 75.5");
        } catch (IllegalArgumentException ex) {
            view.showError(ex.getMessage());
        }
    }
}