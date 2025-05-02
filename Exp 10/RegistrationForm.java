import javax.swing.*;
import java.awt.event.*;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Registration");
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 150, 30);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 150, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 110, 100, 30);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 150, 30);

        JLabel confirmLabel = new JLabel("Confirm:");
        confirmLabel.setBounds(30, 150, 100, 30);
        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(150, 150, 150, 30);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(150, 190, 100, 30);

        JLabel message = new JLabel();
        message.setBounds(30, 230, 300, 30);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String pass = new String(passField.getPassword());
            String confirm = new String(confirmField.getPassword());
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty())
                message.setText("All fields are required");
            else if (!email.contains("@"))
                message.setText("Invalid email");
            else if (!pass.equals(confirm))
                message.setText("Passwords do not match");
            else
                message.setText("Registration Successful");
        });

        f.add(nameLabel); f.add(nameField);
        f.add(emailLabel); f.add(emailField);
        f.add(passLabel); f.add(passField);
        f.add(confirmLabel); f.add(confirmField);
        f.add(registerBtn); f.add(message);
        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);
    }
}
