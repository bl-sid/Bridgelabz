package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.LibraryDatabase;
import com.bridgelabz.model.Book;

/**
 * Servlet implementation class BookDeatailsLoader
 */
@WebServlet("/BookDetailsLoader")
public class BookDetailsLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book Details Loader called");
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		LibraryDatabase database = new LibraryDatabase();
		Book book = database.getBookDetails(bookId, userId);
		
		request.setAttribute("book_object", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookdetails.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
