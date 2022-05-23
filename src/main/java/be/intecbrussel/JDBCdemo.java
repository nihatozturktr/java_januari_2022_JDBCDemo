package be.intecbrussel;

import java.sql.*;
import java.util.Scanner;

public class JDBCdemo {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Database Password");
        /*
        3 delen:
           - database url: mysql: // adressvandb/port/database
           - username : jullie username
           - password : jullie database password
           moktok.intecbrussel.org:33062
         */
        String url = "moktok.intecbrussel.org";
        String port = "33062";
        String database = "JAVAJANNihat";
        String databaseURL = String.format("jdbc:mysql://%s:%s/%s",url,port,database);
        //  System.out.println(databaseURL);
        try {
            Connection connection = DriverManager.getConnection(databaseURL,"JAVAJANNihat",scanner.nextLine());
            System.out.println(connection.isValid(5));
            String query = "SELECT * FROM Brewers WHERE Turnover > 5000;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                // id turnover
                int id = resultSet.getInt("id");
                int turnover = resultSet.getInt("turnover");
                System.out.println("ID: " + id + " - Turnover: " + turnover);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
