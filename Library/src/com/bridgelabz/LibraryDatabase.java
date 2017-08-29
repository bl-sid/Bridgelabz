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
			connection = DriverManager.getConnection(url, "root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> getScienceData(){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "selecet * from Science";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				String name = resultSet.getString("name");
				String category = resultSet.getString("category");
				int price = resultSet.getInt("price");
				Book book = new Book(name, category, price);
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;		
	}
}
