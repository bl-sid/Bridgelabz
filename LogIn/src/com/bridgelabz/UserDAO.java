package com.bridgelabz;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class UserDAO {

	Connection connection = null;
	
	public UserDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mydatabase";
			String username = "root";
			connection = DriverManager.getConnection(url, username, username);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	int save(User user) {
		int status = 0;
		String query = "insert into info (id, fname, lname, email, contact, userpassword) values (?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement =  connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.setInt(1, 0);
			statement.setString(2, user.getFname());
			statement.setString(3, user.getLname());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getContact());
			statement.setString(6, user.getPassword());
			
			status = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	boolean loginCheck(String email, String password) {
		String query = "select userpassword from info where email = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return password.equals(resultSet.getString("userpassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	User getUser(String email) {
		String query = "select fname, lname, contact from info where email = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			String fname = resultSet.getString(1);
			String lname = resultSet.getString(2);
			String contact = resultSet.getString(3);
			User user = new User(fname, lname, email, contact);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	void update( User updatedUser, String email) {
		String query = "update info set fname = ?, lname = ?, email = ?, contact = ? where email = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			statement.setString(1, updatedUser.getFname());
			statement.setString(2, updatedUser.getLname());
			statement.setString(3, updatedUser.getEmail());
			statement.setString(4, updatedUser.getContact());
			statement.setString(5, email);
			int status = statement.executeUpdate();
			System.out.println("update " + status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void delete(String email){
		String query = "delete from info where email = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	LinkedList<User> getAll() {
		LinkedList<User> users = new LinkedList<>();
		String query = "select fname, lname, email, contact from info";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String fname = resultSet.getString(1);
				String lname = resultSet.getString(2);
				String email = resultSet.getString(3);
				String contact = resultSet.getString(4);
				User user = new User(fname, lname, email, contact);
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}
}
