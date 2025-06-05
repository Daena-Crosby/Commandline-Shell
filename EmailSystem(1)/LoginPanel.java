package EmailSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel messageLabel;
    private JFrame parentFrame;

    public LoginPanel(JFrame parent) {
        this.parentFrame = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        gbc.insets = new Insets(5, 5, 5, 5);

        // Email Label and Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        // Password Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(loginButton, gbc);
        gbc.gridx = 1;
        add(registerButton, gbc);

        // Message Label
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);


        // Button Action Listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        // Register Button Action Listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) parentFrame.getContentPane().getLayout();
                cl.show(parentFrame.getContentPane(), "RegisterPanel");
            }
        });
    }

    private void handleLogin() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
    
        if (email.isEmpty() || password.isEmpty()) {
            messageLabel.setText("All fields are required!");
            messageLabel.setForeground(Color.RED);
            return;
        }
    
        // Hash the input password before comparison
        String hashedPassword = AuthService.hashPassword(password);
        boolean success = AuthService.loginUser(email, hashedPassword);
    
        if (success) {
            messageLabel.setText("Login successful!");
            messageLabel.setForeground(Color.GREEN);
    
            // Switch to DashboardPanel
            CardLayout cl = (CardLayout) parentFrame.getContentPane().getLayout();
            cl.show(parentFrame.getContentPane(), "DashboardPanel");
        } else {
            messageLabel.setText("Login failed! Invalid email or password.");
            messageLabel.setForeground(Color.RED);
        }
    }
}