package com.bridgelabz.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.LibraryDatabase;
import com.bridgelabz.model.Book;


@WebServlet("/BookTitleLoader")
public class BookTitleLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book Titles Loader called");
		String category = request.getParameter("category");
		int userId = Integer.parseInt(request.getParameter("user_id"));
		LibraryDatabase database = new LibraryDatabase();
		ArrayList<Book> books = database.getCategoryData(category,userId);
		request.setAttribute("books_list", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booktitles.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
