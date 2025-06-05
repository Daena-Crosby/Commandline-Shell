package EmailSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DashboardPanel extends JPanel {
    public DashboardPanel(JFrame parent) {
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Your Inbox", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        // Placeholder for Email List
        JTextArea emailList = new JTextArea();
        emailList.setEditable(false);
        emailList.setText("No emails to display.");
        add(new JScrollPane(emailList), BorderLayout.CENTER);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel();
        JButton composeButton = new JButton("Compose Email");
        JButton logoutButton = new JButton("Logout");

        bottomPanel.add(composeButton);
        bottomPanel.add(logoutButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Event Handling
        composeButton.addActionListener((ActionEvent e) -> {
            ComposeEmailDialog dialog = new ComposeEmailDialog(parent);
            dialog.setVisible(true);
        });

        logoutButton.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
            cl.show(parent.getContentPane(), "LoginPanel");
        });
    }
}
