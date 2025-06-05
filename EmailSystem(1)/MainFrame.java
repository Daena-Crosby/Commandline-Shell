package EmailSystem;

import javax.swing.*;
import javax.swing.*;
import java.awt.CardLayout;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Email System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());

        // Add panels to the main frame
        add(new LoginPanel(this), "LoginPanel");
        add(new RegisterPanel(this), "RegisterPanel");
        add(new DashboardPanel(this), "DashboardPanel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}