package FEU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Numeric_Data_Manipulation_FEU_GUI {
    // Dhruv Thakar
    // June 17, 2024
    // Prime number checker, Perfect Square Checker, Largest Digit, Even-Odd Count,
    // Product of Digits, Exponential Power, Trigonometric Functions
    // GUI Implementation 

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Numeric Data Manipulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        
        // Create a panel to hold all the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Create a text field for input
        JTextField numberField = new JTextField();
        numberField.setMaximumSize(new Dimension(Integer.MAX_VALUE, numberField.getPreferredSize().height));
        panel.add(new JLabel("Enter a number:"));
        panel.add(numberField);
        
        // Create a button to trigger calculations
        JButton calculateButton = new JButton("Calculate");
        panel.add(calculateButton);
        
        // Create a button to clear the input and results
        JButton clearButton = new JButton("Clear");
        panel.add(clearButton);
        
        // Create a text area to display results
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        
        // Create a text area to display history log
        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        JScrollPane historyScrollPane = new JScrollPane(historyArea);
        panel.add(new JLabel("History:"));
        panel.add(historyScrollPane);
        
        // Add an action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(numberField.getText());
                    if (number < 0) {
                        throw new NumberFormatException();
                    }
                    StringBuilder results = new StringBuilder();
                    StringBuilder history = new StringBuilder();

                    // Prime number checker
                    boolean isPrime = true;
                    if (number <= 1) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i <= Math.sqrt(number); i++) {
                            if (number % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    results.append(number).append(isPrime ? " is a prime number.\n" : " is not a prime number.\n");
                    history.append("Prime check: ").append(isPrime).append("\n");

                    // Perfect square checker
                    double squareRoot = Math.sqrt(number);
                    if (squareRoot % 1 == 0) {
                        results.append(number).append(" is a perfect square.\n");
                    } else {
                        results.append(number).append(" is not a perfect square.\n");
                    }
                    history.append("Perfect square check: ").append(squareRoot % 1 == 0).append("\n");

                    // Factorial calculation
                    long factorial = 1;
                    for (int i = 1; i <= number; i++) {
                        factorial *= i;
                    }
                    results.append("Factorial of ").append(number).append(" is: ").append(factorial).append("\n");
                    history.append("Factorial: ").append(factorial).append("\n");

                    // Reverse digits
                    int reversed = 0;
                    int temp = number;
                    while (temp != 0) {
                        int digit = temp % 10;
                        reversed = reversed * 10 + digit;
                        temp /= 10;
                    }
                    results.append("Reversed number: ").append(reversed).append("\n");
                    history.append("Reversed number: ").append(reversed).append("\n");

                    // Sum of digits
                    int sum = 0;
                    temp = number;
                    while (temp != 0) {
                        int digit = temp % 10;
                        sum += digit;
                        temp /= 10;
                    }
                    results.append("Sum of digits: ").append(sum).append("\n");
                    history.append("Sum of digits: ").append(sum).append("\n");

                    // Largest digit
                    int largestDigit = 0;
                    temp = number;
                    while (temp != 0) {
                        int digit = temp % 10;
                        if (digit > largestDigit) {
                            largestDigit = digit;
                        }
                        temp /= 10;
                    }
                    results.append("Largest digit: ").append(largestDigit).append("\n");
                    history.append("Largest digit: ").append(largestDigit).append("\n");

                    // Even and odd digit count
                    int evenCount = 0;
                    int oddCount = 0;
                    temp = number;
                    while (temp != 0) {
                        int digit = temp % 10;
                        if (digit % 2 == 0) {
                            evenCount++;
                        } else {
                            oddCount++;
                        }
                        temp /= 10;
                    }
                    results.append("Number of even digits: ").append(evenCount).append("\n");
                    results.append("Number of odd digits: ").append(oddCount).append("\n");
                    history.append("Even digits: ").append(evenCount).append(", Odd digits: ").append(oddCount).append("\n");

                    // Product of digits
                    int product = 1;
                    temp = number;
                    while (temp != 0) {
                        int digit = temp % 10;
                        product *= digit;
                        temp /= 10;
                    }
                    results.append("Product of digits: ").append(product).append("\n");
                    history.append("Product of digits: ").append(product).append("\n");

                    // Exponential power
                    String powerStr = JOptionPane.showInputDialog("Enter the power for exponential calculation:");
                    int power = Integer.parseInt(powerStr);
                    double exponentialPower = Math.pow(number, power);
                    results.append(number).append(" raised to the power of ").append(power).append(" is: ").append(exponentialPower).append("\n");
                    history.append(number).append("^").append(power).append(" = ").append(exponentialPower).append("\n");

                    // Trigonometric functions
                    double sinValue = Math.sin(Math.toRadians(number));
                    results.append("Sin value of ").append(number).append(" is: ").append(sinValue).append("\n");

                    double cosValue = Math.cos(Math.toRadians(number));
                    results.append("Cos value of ").append(number).append(" is: ").append(cosValue).append("\n");

                    double tanValue = Math.tan(Math.toRadians(number));
                    results.append("Tan value of ").append(number).append(" is: ").append(tanValue).append("\n");

                    history.append("Sin: ").append(sinValue).append(", Cos: ").append(cosValue).append(", Tan: ").append(tanValue).append("\n");

                    // Display results
                    resultArea.setText(results.toString());
                    historyArea.append(history.toString() + "\n");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid non-negative integer.");
                }
            }
        });

        // Add an action listener to the clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberField.setText("");
                resultArea.setText("");
            }
        });

        // Add the panel to the frame
        frame.getContentPane().add(panel);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}