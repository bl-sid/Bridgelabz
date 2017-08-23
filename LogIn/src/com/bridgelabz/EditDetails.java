package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/EditDetails")
public class EditDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailOld = (String) session.getAttribute("email");
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String contact = request.getParameter("contact");
		String emailNew = request.getParameter("email");
		UserDAO dao = new UserDAO();
		User updatedUser = new User(fname, lname, emailNew, contact);
		dao.update(updatedUser, emailOld);
		session.setAttribute("email", emailNew);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CreateHtml html = new CreateHtml(fname, lname, emailNew, contact);
		out.write(html.getHtml());
		out.close();
	}

}
