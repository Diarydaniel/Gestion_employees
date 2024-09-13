import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        if(nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            return;
        }

        // Logique d'inscription ici
        JOptionPane.showMessageDialog(null, "Inscription réussie !");
    }

    private void handleLogin() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
        if (topFrame != null) {
            topFrame.dispose(); // Fermer la fenêtre d'inscription
            new Login(); // Ouvrir la fenêtre de connexion
        }
    }
}
