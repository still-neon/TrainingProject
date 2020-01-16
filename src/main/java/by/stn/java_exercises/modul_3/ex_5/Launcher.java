package by.stn.java_exercises.modul_3.ex_5;

import by.stn.java_exercises.modul_3.ex_4.ConnectionFactory;

import java.sql.*;

public class Launcher {
	private static final String GET_ALL_QUERY_FORMAT = "SELECT * FROM expenses";
	private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO expenses (num,paydate,receiver,value) VALUES (DEFAULT,?,?,?) RETURNING num";

	private static void print(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "|" + resultSet.getString(2) + "|" + resultSet.getString(3) + "|" + resultSet.getString(4));
		}
	}

	public static void main(String[] args) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_ENTITY_QUERY_FORMAT);
			preparedStatement.setDate(1, Date.valueOf(args[0]));
			preparedStatement.setInt(2, Integer.parseInt(args[1]));
			preparedStatement.setInt(3, Integer.parseInt(args[2]));
			preparedStatement.executeQuery();

			print(con.prepareStatement(GET_ALL_QUERY_FORMAT).executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}