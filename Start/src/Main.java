import java.sql. * ;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:mariadb://localhost:3306/uebungen?user=root&password=123";

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement()) {

            String sqlQuery = "SELECT * FROM t_lager";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer name = resultSet.getInt("stueck");

                System.out.println("Name: " + id + " - " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}