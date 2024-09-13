import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    public Register() {
        // Paramètres de la fenêtre principale
        setTitle("Gestion des employées / Page d'Inscription");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Création des panels principaux
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(28, 89, 80));
        leftPanel.setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new GridBagLayout());

        // Ajouter un icône à gauche
        ImageIcon icon = new ImageIcon("icons/Users.png"); // Remplacer par votre image
        Image img = icon.getImage(); // Obtenir l'image
        Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionner
        icon = new ImageIcon(scaledImg); // Créer un nouvel ImageIcon avec l'image redimensionnée

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(icon);
        iconLabel.setHorizontalAlignment(JLabel.CENTER); // Centrer l'image horizontalement

        // Panneau pour le texte en bas
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(28, 89, 80));
        JLabel textLabel = new JLabel("Système de Gestion des employées");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        textLabel.setForeground(Color.WHITE);
        textLabel.setHorizontalAlignment(JLabel.CENTER); // Centrer le texte
        bottomPanel.add(textLabel);

        // Ajouter l'image et le texte au panneau gauche
        leftPanel.add(iconLabel, BorderLayout.CENTER);
        leftPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Ajouter du texte de bienvenue
        JLabel welcomeLabel = new JLabel("Page d'Inscription");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(28, 89, 80));

        // Labels pour les champs de saisie
        JLabel nomLabel = new JLabel("Nom:");
        JLabel prenomLabel = new JLabel("Prénoms:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Mot de passe:");

        // Champs de saisie du nom, prénom, email et mot de passe
        JTextField nomField = new JTextField(15);
        JTextField prenomField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton registerButton = new JButton("S'inscrire");
        JButton loginButton = new JButton("Se connecter"); // Nouveau bouton de connexion

        // Événement d'inscription
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                // Logique d'inscription ici
                if (email.equals("admin@example.com") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Inscription réussie !");
                } else {
                    JOptionPane.showMessageDialog(null, "Informations invalides !");
                }
            }
        });

        // Événement de connexion
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre d'inscription
                new Login(); // Ouvrir la fenêtre de connexion
            }
        });

        // Agencement des éléments dans le panneau droit
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST; // Alignement à gauche

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Le label de bienvenue occupe deux colonnes
        rightPanel.add(welcomeLabel, gbc);

        gbc.gridwidth = 1; // Réinitialiser pour les autres éléments

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(nomLabel, gbc);

        gbc.gridx = 1;
        rightPanel.add(nomField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(prenomLabel, gbc);

        gbc.gridx = 1;
        rightPanel.add(prenomField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        rightPanel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        rightPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(registerButton, gbc);

        gbc.gridx = 1;
        rightPanel.add(loginButton, gbc); // Ajouter le bouton de connexion à droite du bouton d'inscription

        // Ajouter les panels à la fenêtre
        getContentPane().setLayout(new GridLayout(1, 2));
        getContentPane().add(leftPanel);
        getContentPane().add(rightPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}
