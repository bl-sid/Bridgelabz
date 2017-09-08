package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabz.model.Book;

//DAO class
public class LibraryDatabase {

	Connection connection;	// connection
	final Logger log;

	/**
	 * Loads jdbc driver class and gets connection
	 */
	public LibraryDatabase() {
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
	 * Adds a new book to the database
	 * @param book - reference of the book object to be added
	 * @return	status of the result
	 */
	public void addNewBook(Book book) {
		String query = "insert into books (title, author, category, price, user_id) values (?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setInt(4, book.getPrice());
			statement.setInt(5, book.getUserId());
			statement.executeUpdate();
			log.debug("New book added");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Book could not be added");
		}
		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * updates a book's info
	 * @param book - reference of the book object to be updated
	 * @param oldTitle - old title of the book
	 */
	public void updateBook(Book book, int bookId, int userId){
		String query = "update books set title = ?, author = ?, category = ?, price = ?, user_id = ? where book_id = ? and user_id = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setInt(4, book.getPrice());
			statement.setInt(5, book.getUserId());
			statement.setInt(6, bookId);
			statement.setInt(7, userId);
			statement.executeUpdate();
			log.debug("Book updated");
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Book could not be updated");
		}
		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Deletes a book
	 * @param title title of the book to be deleted
	 */
	public void deleteBook(int bookId, int userId){
		String query = "delete from books where book_id = ? and user_id = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, bookId);
			statement.setInt(2, userId);
			statement.execute();
			log.debug("Book deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Book could not be deleted");
		}
		finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param category - category of which books are to be loaded
	 * @return arraylist of book titles
	 */
	public ArrayList<Book> getCategoryData(String category, int userId) {
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "select * from books where category = ? and user_id = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, category);
			statement.setInt(2, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int bookId = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				
				Book book = new Book(bookId, title, author, category, price, userId);
				books.add(book);
			}
			log.debug("Books added to the list");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Books could not be added to the list");
		}
		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}
	
	/**
	 * @param title - title of the book
	 * @return book object
	 */
	public Book getBookDetails(int bookId, int userId){
		Book book = null;
		String query = "select * from books where book_id = ? and user_id = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, bookId);
			statement.setInt(2, userId);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			String category = resultSet.getString("category");
			int price = resultSet.getInt("price");
			
			book = new Book(title, author, category, price, userId);
			log.debug("Book details retrieved from database");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Error retrieving book information");
		}
		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
	
}
