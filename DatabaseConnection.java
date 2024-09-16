import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Informations de la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_employes";
    private static final String USER = "Daniel";
    private static final String PASSWORD = "Developer25";

    // Méthode pour obtenir la connexion
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Charger le pilote JDBC (facultatif dans les versions modernes)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Impossible de charger le pilote JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données.");
            e.printStackTrace();
        }
        return connection;
    }
}
