package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.model.Request;

public class RequestDao {

	private final static int ID = 1;
	private final static int NAME = 2;
	private final static int EMAIL = 3;
	private final static int MESSAGE = 4;
	private final static int STATUS = 5;
	private final static int TIMESTAMP = 6;

	public static void saveRequest(Request request) {
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO userdata (name, email, message) VALUES (?, ?, ?)");
			statement.setString(1, request.getName());
			statement.setString(2, request.getEmail());
			statement.setString(3, request.getMessage());

			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Request> fetchRequests() {
		List<Request> requests = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from userdata");
			while (resultSet.next()) {
				Request requestData = new Request();
				requestData.setId(resultSet.getString(ID));
				requestData.setName(resultSet.getString(NAME));
				requestData.setEmail(resultSet.getString(EMAIL));
				requestData.setMessage(resultSet.getString(MESSAGE));
				requestData.setIsActive(resultSet.getBoolean(STATUS));
				requestData.setTimestamp(resultSet.getTimestamp(TIMESTAMP));

				requests.add(requestData);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return requests;
	}

	public static void changeStatus(int id, boolean isActive) {
		try {
			Connection connection = getConnection();
			if (isActive) {
				PreparedStatement statement = connection
						.prepareStatement("UPDATE userdata SET status=FALSE WHERE id=? ");
				statement.setInt(1, id);
				statement.executeUpdate();

			} else {
				PreparedStatement statement = connection
						.prepareStatement("UPDATE userdata SET status=TRUE WHERE id=? ");
				statement.setInt(1, id);
				statement.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
