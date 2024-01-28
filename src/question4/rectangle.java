package question4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class rectangle extends JFrame {
    private JTextField lengthField, widthField, resultField;

    public rectangle() {
        setTitle("Rectangle Area Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create labels and text fields
        JLabel lengthLabel = new JLabel("Length: ");
        JLabel widthLabel = new JLabel("Width: ");
        JLabel resultLabel = new JLabel("Area: ");

        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false); // Make the result field read-only

        // Create a button to calculate the area
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateArea();
            }
        });

        // Add components to the frame
        add(lengthLabel);
        add(lengthField);
        add(widthLabel);
        add(widthField);
        add(resultLabel);
        add(resultField);
        add(calculateButton);

        pack(); // Adjust the frame size based on the components
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void calculateArea() {
        try {
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());

            double area = length * width;

            resultField.setText(String.format("%.2f", area));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for length and width.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new rectangle();
            }
        });
    }
}
