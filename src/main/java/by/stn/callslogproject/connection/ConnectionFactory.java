package by.stn.callslogproject.connection;

import java.sql.*;

public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://127.0.0.1:5433/CallsLogProject";
    public static final String USER = "postgres";
    public static final String PASSWORD = "still-neon84";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}