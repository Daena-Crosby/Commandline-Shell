package EmailSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComposeEmailDialog extends JDialog {
    public ComposeEmailDialog(JFrame parent) {
        super(parent, "Compose Email", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel toLabel = new JLabel("To:");
        JLabel subjectLabel = new JLabel("Subject:");
        JLabel bodyLabel = new JLabel("Body:");

        JTextField toField = new JTextField(20);
        JTextField subjectField = new JTextField(20);
        JTextArea bodyArea = new JTextArea(10, 20);

        JButton sendButton = new JButton("Send");
        JButton cancelButton = new JButton("Cancel");

        gbc.insets = new Insets(5, 5, 5, 5);

        // To Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(toLabel, gbc);
        gbc.gridx = 1;
        add(toField, gbc);

        // Subject Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(subjectLabel, gbc);
        gbc.gridx = 1;
        add(subjectField, gbc);

        // Body Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(bodyLabel, gbc);
        gbc.gridx = 1;
        add(new JScrollPane(bodyArea), gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(sendButton, gbc);
        gbc.gridx = 1;
        add(cancelButton, gbc);

        // Event Handling
        sendButton.addActionListener((ActionEvent e) -> {
            String to = toField.getText();
            String subject = subjectField.getText();
            String body = bodyArea.getText();
            // Email sending logic needed
            JOptionPane.showMessageDialog(this, "Email sent to " + to);
            dispose();
        });

        cancelButton.addActionListener((ActionEvent e) -> dispose());
    }
}
