package by.stn.java_exercises.modul_3.ex_4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Launcher {
	private static final String GET_ALL_QUERY_FORMAT = "SELECT * FROM expenses";
	private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO expenses (num,paydate,receiver,value) VALUES (DEFAULT,'%s',%s,%s) RETURNING num";

	private static void print(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "|" + resultSet.getString(2) + "|" + resultSet.getString(3) + "|" + resultSet.getString(4));
		}
	}

	public static void main(String[] args) {
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement statement = con.createStatement();

			statement.executeQuery(String.format(INSERT_ENTITY_QUERY_FORMAT, args[0], args[1], args[2]));
			print(statement.executeQuery(GET_ALL_QUERY_FORMAT));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}