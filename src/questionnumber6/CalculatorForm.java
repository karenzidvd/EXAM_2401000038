package questionnumber6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorForm extends JFrame {
    private JTextField textField;
    private double num1, num2, result;
    private char operator;

    public CalculatorForm() {
        // Set up the frame
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // Set up the components
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            int finalI = i;
            numberButtons[i].addActionListener(e -> textField.setText(textField.getText() + finalI));
        }

        JButton addButton = createOperatorButton("+");
        JButton subtractButton = createOperatorButton("-");
        JButton multiplyButton = createOperatorButton("*");
        JButton divideButton = createOperatorButton("/");
        JButton equalButton = new JButton("=");
        JButton clearButton = new JButton("C");

        // Set up layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(divideButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(multiplyButton);

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(subtractButton);

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(clearButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(addButton);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Set up button actions
        addButton.addActionListener(e -> handleOperatorButton('+'));
        subtractButton.addActionListener(e -> handleOperatorButton('-'));
        multiplyButton.addActionListener(e -> handleOperatorButton('*'));
        divideButton.addActionListener(e -> handleOperatorButton('/'));
        equalButton.addActionListener(e -> calculateResult());
        clearButton.addActionListener(e -> clearTextField());
    }

    private JButton createOperatorButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.addActionListener(e -> handleOperatorButton(label.charAt(0)));
        return button;
    }

    private void handleOperatorButton(char op) {
        if (textField.getText().isEmpty()) {
            return;
        }
        num1 = Double.parseDouble(textField.getText());
        operator = op;
        clearTextField();
    }

    private void calculateResult() {
        if (textField.getText().isEmpty()) {
            return;
        }
        num2 = Double.parseDouble(textField.getText());
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    clearTextField();
                    return;
                }
                break;
        }
        textField.setText(String.valueOf(result));
    }

    private void clearTextField() {
        textField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorForm calculatorForm = new CalculatorForm();
            calculatorForm.setVisible(true);
        });
    }
}
