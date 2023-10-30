import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Datenbank {
    final int Kontonummer = 1;

    private Connection connection;

    public Datenbank() {
        // Konstruktor: Hier können Sie die Datenbankverbindung initialisieren
        verbindeDatenbank();
    }

    public void verbindeDatenbank() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String jdbcUrl = "jdbc:mariadb://localhost:3306/buchhaltung?user=root&password=123";
            connection = DriverManager.getConnection(jdbcUrl);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTransaktionen() {
        try {
            String sqlQuery = "SELECT TransaktionsID, Betrag FROM Transaktionen";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ArrayList<String> transaktionen =  new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("TransaktionsID");
                Double betrag = resultSet.getDouble("Betrag");
                transaktionen.add("TransaktionsID: " + id + ", Betrag: " + betrag);
            }
            return transaktionen;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  new ArrayList<>();
    }

    public void transaktionSpeichern(int Betrag, Date Datum, String Art, Boolean PlusMinus) {
        try {
            String sqlQuery = "INSERT INTO Transaktionen (Kontonummer, Datum, Art, Betrag, PlusMinus) VALUES (" + Kontonummer + ", '" + Datum + "', '" + Art + "', '" + Betrag + "', '" + PlusMinus + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void schließeVerbindung() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
