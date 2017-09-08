package com.bridgelabz.model;

// Plain Old Java Object class with getters
public class Book {
	private int bookId;
	private String title;
	private String author;
	private String category;
	private int price;
	private int userId; 

	public Book(String title, String author, String category, int price, int userId){
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.userId = userId;
	}
	
	public Book(int bookId, String title, String author, String category, int price, int userId){
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.userId = userId;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}
}
