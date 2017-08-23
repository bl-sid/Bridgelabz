package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		
		User user = new User(fname, lname, email, contact, password);
		UserDAO dao = new UserDAO();
		dao.save(user);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CreateHtml html = new CreateHtml(fname, lname, email, contact);
		out.write(html.getHtml());
		out.close();
	}
}
	
