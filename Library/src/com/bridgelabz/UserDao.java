package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserDao {

	Connection connection; // Connection
	final Logger log;
	
	/**
	 * Loads jdbc driver class and gets connection
	 */
	public UserDao() {
		 log = Logger.getRootLogger();
		connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library";
			connection = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds user to the database
	 * @param user - user to be added
	 * @return status of the database operation
	 */
	public int addUser(User user) {
		String query = "insert into user (name, email, contact, gender, password) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getContact());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getPassword());

			int status = statement.executeUpdate();
			log.debug("User registered successfully");
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("User registration failed");
		}
		return 0;
	}

	/**
	 * CHecks if user has logged in with correct credentials
	 * @param email - email entered by the user
	 * @param password - password entered by the user
	 * @return true if email and password matches with the database values
	 */
	public boolean logInCheck(String email, String password) {
		String query = "select password from user where email = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			if (password.equals(resultSet.getString("password"))) {
				log.debug("User successfully logged in");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Log in failed. Email or password is wrong");
		}
		return false;
	}
}
