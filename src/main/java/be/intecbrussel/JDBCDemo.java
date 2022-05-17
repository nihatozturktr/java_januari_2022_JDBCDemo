package be.intecbrussel;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        3 Delen:
            - Database URL: jdbc:mysql://addressvandb:port/database
            - Username: jullie database username
            - Password: jullie database password
         */

        String url = "db.intecbrussel.be";
        String port = "33100";
        String database = "student07";

        String databaseURL = String.format("jdbc:mysql://%s:%s/%s", url, port, database);

        try {
            Connection connection = DriverManager.getConnection(databaseURL, "student07", scanner.nextLine());
            System.out.println(connection.isValid(5));

            String query = "SELECT * FROM brewers WHERE Turnover > 5000;";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                // id turnover
                int id = resultSet.getInt("id");
                int turnover = resultSet.getInt("turnover");

                System.out.println("ID: " + id + " - Turnover: " + turnover);
            }


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
