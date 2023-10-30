import java.sql. * ;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:mariadb://localhost:3306/buchhaltung?user=root&password=123";

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement()) {

            String sqlQuery = "SELECT * FROM Transaktionen";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("TransaktionsID");
                Integer name = resultSet.getInt("Betrag");

                System.out.println(id + " " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}