package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookTitleLoader")
public class BookTitleLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book Titles Loader called");
		String category = request.getParameter("category");
		StringBuilder builder = new StringBuilder();
		LibraryDatabase database = new LibraryDatabase();
		PrintWriter out = response.getWriter();
		ArrayList<String> bookTitles = database.getCategoryData(category);
		builder.append("<ol>");
		for (String title : bookTitles) {
			builder.append("<li>");
			builder.append("<a class='book-title' data-toggle='modal' href='#'>" + title + "</a>");
			builder.append("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
			builder.append("<a href='#' class='form-pull-right book-edit " + title + "'>edit</a>");
			builder.append("</li>");
		}
		builder.append("</ol>");
		out.println(builder.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
