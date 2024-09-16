import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionListener; // Pour ActionListener
import java.awt.event.ActionEvent;    // Pour ActionEvent
public class EvenementLogin implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public EvenementLogin(JTextField usernameField, JPasswordField passwordField, JButton loginButton, JButton registerButton) {
        this.usernameField = usernameField;
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
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Vérification des champs vides
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            return;
        }

        // Connexion à la base de données pour vérifier l'utilisateur
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM employes WHERE email = ? AND mot_de_passe = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Connexion réussie !");
            } else {
                JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect !");
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
