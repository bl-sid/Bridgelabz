package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInUser
 */
@WebServlet("/LogInUser")
public class LogInUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(email, password);
		UserDao dao = new UserDao();
		boolean loggedIn = dao.checkLogIn(user);
		PrintWriter out = response.getWriter();
		out.println(loggedIn);
		if (loggedIn) {
			Cookie cookie = new Cookie("email", email);
			response.addCookie(cookie);
			int counter = dao.getCounter();
			counter++;
			dao.updateCounterInDatabase(counter);
			response.sendRedirect("welcome.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
