package com.bridgelabz.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final Logger log = Logger.getRootLogger();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
        if(!matcher.find() || (password.length() < 8)){
        	response.sendRedirect("index.jsp");
        	log.error("Email or password could not be validated");
        }
		UserDao dao = new UserDao();
		User user = dao.logInCheck(email, password);

		if (user != null) {			
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("id", String.valueOf(user.getId()));
			session.setAttribute("name", user.getName());
			response.sendRedirect("homepage.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
