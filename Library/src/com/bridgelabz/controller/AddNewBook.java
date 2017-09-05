package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.LibraryDatabase;
import com.bridgelabz.model.Book;

@WebServlet("/AddNewBook")
public class AddNewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		//to know old title to edit database if the title is changed after editing book info
		String oldTitle = request.getParameter("oldTitle");

		Book book = new Book(title, author, category, price);
		LibraryDatabase database = new LibraryDatabase();
		if (oldTitle.equals("")) {
			database.addNewBook(book);			
		} else {
			database.updateBook(book, oldTitle);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
