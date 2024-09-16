import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EvenementLogin implements ActionListener {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public EvenementLogin(JTextField emailField, JPasswordField passwordField, JButton loginButton, JButton registerButton) {
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.loginButton = loginButton;
        this.registerButton = registerButton;
        this.loginButton.addActionListener(this);
        this.registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            handleLogin();
        } else if (e.getSource() == registerButton) {
            handleRegister();
        }
    }

    private void handleLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Vérification des champs vides
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            return;
        }

        // Connexion à la base de données et vérification des informations
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM employes WHERE email = ? AND mot_de_passe = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Informations correctes, ouvrir la fenêtre Home
                SwingUtilities.invokeLater(() -> {
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                    if (topFrame != null) {
                        topFrame.dispose(); // Fermer la fenêtre de connexion
                    }
                    // Créer et afficher la fenêtre Home
                    Home home = new Home();
                    home.setVisible(true);
                });
            } else {
                JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void handleRegister() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(registerButton);
        if (topFrame != null) {
            topFrame.dispose(); // Fermer la fenêtre de connexion
            new Register(); // Ouvrir la fenêtre d'inscription
        }
    }
}
