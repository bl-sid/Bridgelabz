package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryDatabase {

	Connection connection;

	public LibraryDatabase() {
		connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library";
			connection = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	public int addNewBook(Book book) {
		String query = "insert into books (title, author, category, price) values (?, ?, ?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setInt(4, book.getPrice());
			int status = statement.executeUpdate();
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void updateBook(Book book, String oldTitle){
		String query = "update books set title = ?, author = ?, category = ?, price = ? where title = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setInt(4, book.getPrice());
			statement.setString(5, oldTitle);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(String title){
		String query = "delete from books where title = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, title);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getCategoryData(String category) {
		ArrayList<String> bookTitles = new ArrayList<String>();
		String query = "select title from books where category = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, category);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				bookTitles.add(title);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookTitles;
	}
	
	public Book getBookDetails(String title){
		Book book = null;
		String query = "select * from books where title = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, title);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			String author = resultSet.getString("author");
			String category = resultSet.getString("category");
			int price = resultSet.getInt("price");
			
			book = new Book(title, author, category, price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
}
