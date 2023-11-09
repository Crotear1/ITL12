import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
            String sqlQuery = "SELECT TransaktionsID, Betrag, Datum, Art, PlusMinus FROM Transaktionen";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ArrayList<String> transaktionen =  new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("TransaktionsID");
                Double betrag = resultSet.getDouble("Betrag");
                LocalDate datum = resultSet.getDate("Datum").toLocalDate();
                String art = resultSet.getString("Art");
                Boolean plusMinus = resultSet.getBoolean("PlusMinus");
                if (plusMinus) {
                    betrag = betrag * -1;
                } else {
                    betrag = betrag * 1;
                }
                transaktionen.add("TransaktionsID: " + id + ", Betrag: " + betrag + ", Datum: " + datum + ", Art: " + art);
            }
            System.out.println(transaktionen);
            return transaktionen;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  new ArrayList<>();
    }

    public void transaktionSpeichern(int Betrag, LocalDate Datum, String Art, Boolean PlusMinus) {
        try {
            String sqlQuery = "INSERT INTO Transaktionen (Kontonummer, Datum, Art, Betrag, PlusMinus) VALUES (" + Kontonummer + ", '" + Datum + "', '" + Art + "', '" + Betrag + "', '" + PlusMinus + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTransaktionenWithDate(LocalDate date) {
        try {
            String sqlQuery = "SELECT TransaktionsID, Betrag, Datum, Art, PlusMinus FROM Transaktionen WHERE Datum = '" + date + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            ArrayList<String> transaktionen =  new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("TransaktionsID");
                Double betrag = resultSet.getDouble("Betrag");
                LocalDate datum = resultSet.getDate("Datum").toLocalDate();
                String art = resultSet.getString("Art");
                Boolean plusMinus = resultSet.getBoolean("PlusMinus");
                if (plusMinus) {
                    betrag = betrag * -1;
                } else {
                    betrag = betrag * 1;
                }
                transaktionen.add("TransaktionsID: " + id + ", Betrag: " + betrag + ", Datum: " + datum + ", Art: " + art);
            }
            System.out.println(transaktionen);
            return transaktionen;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  new ArrayList<>();
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
