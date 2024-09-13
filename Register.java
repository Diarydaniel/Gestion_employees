import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    public Register() {
        // Paramètres de la fenêtre d'inscription
        setTitle("Inscription");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Création du panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        // Labels et champs de saisie
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Mot de passe:");
        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("S'inscrire");

        // Événement d'inscription
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                // Logique d'inscription ici
                JOptionPane.showMessageDialog(null, "Inscription réussie!");
                dispose(); // Fermer la fenêtre d'inscription
            }
        });

        // Agencement des éléments dans le panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 1;
        panel.add(registerButton, gbc);

        // Ajouter le panel à la fenêtre
        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}
