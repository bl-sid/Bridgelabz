package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bridgelabz.dao.LibraryDatabase;
import com.bridgelabz.model.Book;



/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book Editor called");
		String title = request.getParameter("title");
		int id = Integer.parseInt(request.getParameter("id"));
		LibraryDatabase database = new LibraryDatabase();
		Book book = database.getBookDetails(title, id);
		
		JSONObject jsonBook = new JSONObject();
		jsonBook.put("title", book.getTitle());
		jsonBook.put("author", book.getAuthor());
		jsonBook.put("category", book.getCategory());
		jsonBook.put("price", book.getPrice());		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		out.print(jsonBook);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
