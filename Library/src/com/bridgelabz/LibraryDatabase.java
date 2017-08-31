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
	
	
	public int addBook(Book book){
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
	
	
	public ArrayList<Book> getScienceData(){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "select * from books";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				int price = resultSet.getInt("price");
				if(category.equals("Science")){
					Book book = new Book(title, author, category, price);
					books.add(book);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;		
	}
}
