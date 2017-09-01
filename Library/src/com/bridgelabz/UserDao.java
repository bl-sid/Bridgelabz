package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

Connection connection;
	
	public UserDao() {
		connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library";
			connection = DriverManager.getConnection(url, "root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addUser(User user){
		String query = "insert into user (name, email, contact, gender, password) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getName());			
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getContact());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getPassword());
			
			int status = statement.executeUpdate();
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean logInCheck(String email, String password){
		String query = "select password from user where email = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			if(password.equals(resultSet.getString("password"))){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}