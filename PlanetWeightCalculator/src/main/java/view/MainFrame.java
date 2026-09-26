package view;

import controller.CalculatorController;
import model.ModelObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame implements ModelObserver {
    private final DefaultTableModel tableModel;
    private final JLabel statusLabel;
    private CalculatorController controller;

    private Double lastEnteredWeight = null;

    public MainFrame() {
        super("Калькулятор веса на планетах");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton btnOpenInput = new JButton("Ввести данные");
        btnOpenInput.setFont(new Font("Arial", Font.BOLD, 13));
        btnOpenInput.addActionListener(e -> {
            if (controller != null) {
                controller.onInputDataRequested();
            }
        });
        topPanel.add(btnOpenInput);
        add(topPanel, BorderLayout.NORTH);

        String[] columns = {"Планета / Объект", "Вес (кг)"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable resultsTable = new JTable(tableModel);
        resultsTable.setRowHeight(24);
        add(new JScrollPane(resultsTable), BorderLayout.CENTER);

        statusLabel = new JLabel("Нажмите «Ввести данные» для расчета веса.", SwingConstants.CENTER);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        add(statusLabel, BorderLayout.SOUTH);
    }

    public void setController(CalculatorController controller) {
        this.controller = controller;
    }

    public Double getLastEnteredWeight() {
        return lastEnteredWeight;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void onWeightCalculated(double earthWeight, Map<String, Double> planetWeights) {
        this.lastEnteredWeight = earthWeight;

        tableModel.setRowCount(0);
        for (Map.Entry<String, Double> entry : planetWeights.entrySet()) {
            tableModel.addRow(new Object[]{
                    entry.getKey(),
                    String.format("%.2f", entry.getValue())
            });
        }
        statusLabel.setText(String.format("Вес на Земле: %.2f кг", earthWeight));
    }
}