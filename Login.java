import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login() {
        // Paramètres de la fenêtre principale
        setTitle("Gestion des employées / Page de Connexion");
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
        JLabel welcomeLabel = new JLabel("Page de Connexion");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(28, 89, 80));

        // Labels pour les champs de saisie
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Mot de passe:");

        // Champs de saisie du nom d'utilisateur et du mot de passe
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Connexion");
        JButton registerButton = new JButton("S'inscrire"); 

        // Événement de connexion
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Logique d'authentification ici
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie !");
                } else {
                    JOptionPane.showMessageDialog(null, "Identifiants invalides !");
                }
            }
        });

        // Événement d'inscription
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre de connexion
                new Register(); // Ouvrir la fenêtre d'inscription
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
        rightPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        rightPanel.add(usernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        rightPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(loginButton, gbc);

        gbc.gridx = 1;
        rightPanel.add(registerButton, gbc); // Ajouter le bouton d'inscription à droite du bouton de connexion

        // Ajouter les panels à la fenêtre
        getContentPane().setLayout(new GridLayout(1, 2));
        getContentPane().add(leftPanel);
        getContentPane().add(rightPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
