package by.stn.callslogproject;

import java.sql.*;

public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://127.0.0.1:5433/CallsLogProject";
    public static final String USER = "postgres";
    public static final String PASSWORD = "LockDog84";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return connection;
    }

    public static void main(String[] args) {
        ConnectionFactory.getConnection();
    }
}