import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static double num1 = 0, num2 = 0, result = 0;
    static char operator;

    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");
        JTextField tf = new JTextField();
        tf.setBounds(30, 40, 280, 30);
        String[] btns = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "=", "C", "+"
        };
        JButton[] buttons = new JButton[16];
        int x = 30, y = 100;
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(btns[i]);
            buttons[i].setBounds(x, y, 60, 40);
            f.add(buttons[i]);
            x += 70;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 50;
            }
        }

        for (JButton b : buttons) {
            b.addActionListener(e -> {
                String cmd = b.getText();
                if (cmd.matches("[0-9]"))
                    tf.setText(tf.getText() + cmd);
                else if (cmd.equals("C"))
                    tf.setText("");
                else if (cmd.equals("=")) {
                    num2 = Double.parseDouble(tf.getText());
                    switch (operator) {
                        case '+': result = num1 + num2; break;
                        case '-': result = num1 - num2; break;
                        case '*': result = num1 * num2; break;
                        case '/': result = num1 / num2; break;
                    }
                    tf.setText(String.valueOf(result));
                } else {
                    num1 = Double.parseDouble(tf.getText());
                    operator = cmd.charAt(0);
                    tf.setText("");
                }
            });
        }

        f.add(tf);
        f.setSize(350, 350);
        f.setLayout(null);
        f.setVisible(true);
    }
}
