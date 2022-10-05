package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;


import java.sql.*;

public class Util {
	private static final Util util = new Util("jdbc:postgresql://localhost:5432/test", "Test", "123");
	private static Connection connection;

	public Util(String dBUrl, String usr, String pass) {
		try {
			connection = DriverManager.getConnection(dBUrl, usr, pass);
		} catch (SQLException ignored) {
		}
	}
	private static void executeUpdate(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
	}
	public static void createTable () throws SQLException {
		String query = "CREATE TABLE users " +
				"(name TEXT, lastName TEXT, age INTEGER)";
		executeUpdate(query);
	}
	public static void addUser(User user) throws SQLException {
		String query = "INSERT INTO users VALUES ('" +
				user.getName() + "', '"	+
				user.getLastName() + "', " +
				user.getAge().intValue()+")";
		executeUpdate(query);
	}
	public static void selectAll() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(
				"SELECT * FROM users");
		while (result.next()) {
			String name =  result.getString("name");
			String lastName =  result.getString("lastName");
			String age =  result.getString("age");
			System.out.println("|" + name + "|" + lastName + "|" + age);
		}
	}
	public static void drop() throws SQLException {
		String query = "DROP TABLE users";
		executeUpdate(query);
	}
}
