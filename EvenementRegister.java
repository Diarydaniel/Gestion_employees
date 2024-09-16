import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionListener; // Pour ActionListener
import java.awt.event.ActionEvent;    // Pour ActionEvent

public class EvenementRegister implements ActionListener {

    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;

    public EvenementRegister(JTextField nomField, JTextField prenomField, JTextField emailField, JPasswordField passwordField, JButton registerButton, JButton loginButton) {
        this.nomField = nomField;
        this.prenomField = prenomField;
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.registerButton = registerButton;
        this.loginButton = loginButton;
        this.registerButton.addActionListener(this);
        this.loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            handleRegister();
        } else if (e.getSource() == loginButton) {
            handleLogin();
        }
    }

    private void handleRegister() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Vérification des champs vides
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            return;
        }

        // Insertion des données dans la base de données
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO employes (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inscription réussie !");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void handleLogin() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
        if (topFrame != null) {
            topFrame.dispose(); // Fermer la fenêtre d'inscription
            new Login(); // Ouvrir la fenêtre de connexion
        }
    }
}
