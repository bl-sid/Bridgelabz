package com.bridgelabz;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Logger log = Logger.getRootLogger();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		if(name.length() < 3){
			log.error("Name is too short");
			response.sendRedirect("registration.jsp");
		} else{
			Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if(!matcher.find()){
	        	response.sendRedirect("registration.jsp");
	        	log.error("Email validation failed");
	        } else if(contact.length() != 10){
				response.sendRedirect("registration.jsp");
				log.error("Contact number is not 10 digits");
			} else if(!gender.equals("Male") && !gender.equals("Female")){
				response.sendRedirect("registration.jsp");
				log.error("NO gender selected");
			} else if(password.length() < 8){
				log.error("Password is too short");
				response.sendRedirect("registration.jsp");
			} else{
				User user = new User(name, email, contact, gender, password);
				
				UserDao dao = new UserDao();
				dao.addUser(user);
				
				response.sendRedirect("homepage.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
