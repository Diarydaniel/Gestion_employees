import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        if(username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            return;
        }

        // Logique d'authentification ici
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Connexion réussie !");
        } else {
            JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect !");
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
