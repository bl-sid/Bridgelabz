package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String title = request.getParameter("title");
		int id = Integer.parseInt(request.getParameter("id"));
		LibraryDatabase database = new LibraryDatabase();
		Book book = database.getBookDetails(title, id);
		
		request.setAttribute("book_object", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookdetails.jsp");
		dispatcher.forward(request, response);
		
		//HttpSession session = request.getSession();
		//String name = (String) session.getAttribute("name");
		
		
		
		/*PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		StringBuilder builder = new StringBuilder();
		builder.append("<div class='container'>"+
				"<table class='table table-striped'>\n" + 
				"    <tbody>\n" +
				"      <tr>\n" + 
				"        <th>Title</th>\n" + 
				"        <td>" + book.getTitle() +"</td>\n" + 
				"      </tr>\n" + 
				"      <tr>\n" + 
				"        <th>Author</th>\n" + 
				"        <td>" + book.getAuthor() +"</td>\n" + 
				"      </tr>\n" + 
				"      <tr>\n" + 
				"        <th>Category</th>\n" + 
				"        <td>" + book.getCategory() +"</td>\n" + 
				"      </tr>\n" + 
				"      <tr>\n" + 
				"        <th>Price</th>\n" + 
				"        <td>" + book.getPrice() +"</td>\n" + 
				"      </tr>\n" + 
				"	   <tr> \n" + 
				"	   	<th>Added By</th>\n" + 
				"		<td> " + name + "</td>  \n" + 
				"	   </tr>\n" +
				"    </tbody>\n" + 
				"  </table>\n" + 
				"</div>");
		out.println(builder.toString());*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
