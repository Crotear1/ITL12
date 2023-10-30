import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {
    private Connection connection;

    public Datenbank() {
        // Konstruktor: Hier können Sie die Datenbankverbindung initialisieren
    }

    public void verbindeUndFühreAbfrageAus() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String jdbcUrl = "jdbc:mariadb://localhost:3306/buchhaltung?user=root&password=123";
            connection = DriverManager.getConnection(jdbcUrl);

            String sqlQuery = "SELECT * FROM Transaktionen";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("TransaktionsID");
                Double betrag = resultSet.getDouble("Betrag");

                System.out.println("TransaktionsID: " + id + ", Betrag: " + betrag);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
