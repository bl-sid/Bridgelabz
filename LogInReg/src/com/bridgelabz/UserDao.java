package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class UserDao {
	
	private Connection connection;
	
	public UserDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/login";
			String password = "root";
			connection = DriverManager.getConnection(url, password, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void registerUser(User user){
		String query = "insert into user (id, email, password) values (?, ?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.setInt(1, 0);
			statement.setString(2, user.email);
			statement.setString(3, user.password);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getCounter(){
		String query = "select count from counter";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery();
			resultSet.next();
			int counter = resultSet.getInt(1);
			return counter;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void updateCounterInDatabase(int counter){
			String query = "update counter set count = ?";
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(query);
				statement.setInt(1, counter);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
	
	public boolean checkLogIn(User user){
		String query = "select * from user where email = ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, user.email);
			ResultSet resultSet = (ResultSet) statement.executeQuery();
			resultSet.next();
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			if(email.equals(user.email) && password.equals(user.password)){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
}
