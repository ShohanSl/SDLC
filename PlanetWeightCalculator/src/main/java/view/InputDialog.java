package view;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class InputDialog extends JDialog {
    private final JTextField weightField;
    private boolean confirmed = false;

    public InputDialog(Frame parent, Double initialWeight) {
        super(parent, "Ввод данных", true);
        setLayout(new BorderLayout(10, 10));
        setSize(320, 150);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        inputPanel.add(new JLabel("Вес на Земле (кг):"));

        weightField = new JTextField(10);
        if (initialWeight != null) {
            weightField.setText(String.format(Locale.US, "%.2f", initialWeight));
        }
        inputPanel.add(weightField);
        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnOk = new JButton("Рассчитать");
        JButton btnCancel = new JButton("Отмена");

        btnOk.addActionListener(e -> {
            confirmed = true;
            dispose();
        });
        btnCancel.addActionListener(e -> dispose());

        buttonPanel.add(btnOk);
        buttonPanel.add(btnCancel);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getInputText() {
        return weightField.getText().trim();
    }
}