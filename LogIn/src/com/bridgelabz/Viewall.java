package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Viewall extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		if(email == null) {
			response.sendRedirect("index.html");
		} else {
			UserDAO dao = new UserDAO();
			LinkedList<User> users = dao.getAll();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			ViewallHtml html = new ViewallHtml();
			out.println(html.createHtml(users));
		}		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
