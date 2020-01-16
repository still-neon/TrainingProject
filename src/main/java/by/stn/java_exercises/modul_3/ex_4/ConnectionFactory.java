package by.stn.java_exercises.modul_3.ex_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL = "jdbc:postgresql://127.0.0.1:5430/trainingBase";
	public static final String USER = "postgres";
	public static final String PASSWORD = "still-neon84";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}