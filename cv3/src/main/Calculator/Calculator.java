package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JTextField resultField;
    private JComboBox<String> operationComboBox;

    public Calculator() {
        setTitle("Kalkulačka");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("První číslo:"));
        number1Field = new JTextField();
        number1Field.setName("number1Field");  // Důležité pro testování
        panel.add(number1Field);

        panel.add(new JLabel("Operace:"));
        operationComboBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        operationComboBox.setName("operationComboBox");  // Důležité pro testování
        panel.add(operationComboBox);

        panel.add(new JLabel("Druhé číslo:"));
        number2Field = new JTextField();
        number2Field.setName("number2Field");  // Důležité pro testování
        panel.add(number2Field);

        panel.add(new JLabel("Výsledek:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setName("resultField");  // Důležité pro testování
        panel.add(resultField);

        JButton calculateButton = new JButton("Vypočítat");
        calculateButton.setName("calculateButton");  // Důležité pro testování
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        panel.add(calculateButton);

        JButton clearButton = new JButton("Vymazat");
        clearButton.setName("clearButton");  // Důležité pro testování
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number1Field.setText("");
                number2Field.setText("");
                resultField.setText("");
            }
        });
        panel.add(clearButton);

        add(panel);
    }

    private void calculate() {
        try {
            double number1 = Double.parseDouble(number1Field.getText());
            double number2 = Double.parseDouble(number2Field.getText());
            String operation = (String) operationComboBox.getSelectedItem();
            double result = 0;

            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        JOptionPane.showMessageDialog(this, "Nelze dělit nulou!", "Chyba", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = number1 / number2;
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Neplatný vstup! Zadejte čísla.", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}