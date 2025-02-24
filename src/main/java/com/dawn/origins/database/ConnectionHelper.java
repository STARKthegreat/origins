package com.dawn.origins.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHelper {
    private static String url = "jdbc:postgresql://localhost:5432/mydatabase";
    private static String username = "root";
    private static String password = "password";

    public static void loadDatabaseDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL
            // Class.forName("org.postgresql.Driver"); // For PostgreSQL
            System.out.println("Database driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void connectToDatabase() {
        try {

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connected to the database successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUsers() {
        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
