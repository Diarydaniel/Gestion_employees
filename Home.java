import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Home extends JFrame {

    public Home() {
        // Paramètres du JFrame
        setTitle("Employee Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panneau principal (BorderLayout)
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panneau de gauche (menu)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(33, 47, 61)); // Vert foncé pour le menu

        // Icones pour les boutons (avec redimensionnement)
        ImageIcon homeIcon = createScaledIcon("icons/home.png", 30, 30);
        ImageIcon addIcon = createScaledIcon("icons/Users.png", 30, 30);

        // Label pour l'admin avec taille préférée ajustée
        JLabel welcomeLabel = new JLabel("<html><div style='text-align:center;'>Welcome, <br><strong>admin</strong></div></html>");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setPreferredSize(new Dimension(50, 60)); // Ajuster la taille selon les besoins

        // Panneau pour le welcomeLabel avec des marges
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBackground(new Color(33, 47, 61)); // Assurez-vous que le fond est le même que celui du menu
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Marges autour du label
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        // Boutons stylisés pour le menu
        JButton homeButton = createStyledButton("Home", homeIcon);
        JButton addEmployeeButton = createStyledButton("Add Employee", addIcon);
        JButton logoutButton = createStyledButton("Logout", null);
        logoutButton.setBackground(new Color(231, 76, 60)); // Rouge pour le bouton logout

        // Ajout des éléments au menu
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(welcomePanel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(homeButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(addEmployeeButton);
        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(logoutButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Panneau principal (contenu central)
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // Panneau des statistiques en haut
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 15, 15));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        statsPanel.setBackground(Color.WHITE);

        // Ajout des labels de statistiques avec des couleurs adaptées
        statsPanel.add(createStatPanel("Total Employees", "2", new Color(52, 73, 94)));
        statsPanel.add(createStatPanel("Total Presents", "2", new Color(52, 73, 94)));
        statsPanel.add(createStatPanel("Total Inactive Employees", "0", new Color(52, 73, 94)));

        // Panneau des données des employés (graphique fictif)
        JPanel chartPanel = new JPanel(new BorderLayout());
        JLabel chartLabel = new JLabel("Employees Data Chart", SwingConstants.CENTER);
        chartLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Graphique (exemple simple avec une barre colorée)
        JPanel barChart = new JPanel();
        barChart.setBackground(new Color(230, 126, 34)); // Couleur orange pour la barre
        barChart.setPreferredSize(new Dimension(400, 150));

        chartPanel.add(chartLabel, BorderLayout.NORTH);
        chartPanel.add(barChart, BorderLayout.CENTER);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Ajouter les composants au panneau central
        contentPanel.add(statsPanel, BorderLayout.NORTH);
        contentPanel.add(chartPanel, BorderLayout.CENTER);

        // Ajouter le menu et le contenu au panneau principal
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);
    }

    // Méthode pour créer une icône redimensionnée
    private ImageIcon createScaledIcon(String path, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Méthode pour créer un panneau de statistiques stylisé
    private JPanel createStatPanel(String title, String value, Color backgroundColor) {
        JPanel statPanel = new JPanel();
        statPanel.setBackground(backgroundColor);
        statPanel.setLayout(new BorderLayout());
        statPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        statPanel.add(titleLabel, BorderLayout.NORTH);
        statPanel.add(valueLabel, BorderLayout.CENTER);
        return statPanel;
    }

    // Méthode pour créer des boutons stylisés
    private JButton createStyledButton(String text, Icon icon) {
        JButton button = new JButton(text, icon);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 50));
        button.setFocusPainted(false);
        button.setBackground(new Color(0, 184, 148)); // Vert pour les boutons
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Home frame = new Home();
            frame.setVisible(true);
        });
    }
}
