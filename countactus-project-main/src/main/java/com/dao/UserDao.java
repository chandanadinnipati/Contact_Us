package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDao {
	public static boolean isValidUser(User user) {
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from adminData where name=?");
			statement.setString(1, user.getUserName());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next() && resultSet.getString("password").equals(user.getPassword())) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/ContactUs", "postgres", "2409");
		} catch (Exception e) {
			e.getMessage();
		}
		return connection;
	}
}
