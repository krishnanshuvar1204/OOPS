import javax.swing.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login Form");
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 30);
        JTextField userField = new JTextField();
        userField.setBounds(100, 20, 150, 30);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 30);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 30);
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 100, 80, 30);
        JLabel message = new JLabel();
        message.setBounds(20, 140, 200, 30);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if(user.equals("admin") && pass.equals("password"))
                message.setText("Login Successful");
            else
                message.setText("Invalid Credentials");
        });

        f.add(userLabel); f.add(userField);
        f.add(passLabel); f.add(passField);
        f.add(loginBtn); f.add(message);
        f.setSize(300, 250);
        f.setLayout(null);
        f.setVisible(true);
    }
}
