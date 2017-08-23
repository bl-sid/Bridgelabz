package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean logged = false;
		UserDAO dao = new UserDAO();
		
		if (email == null || email.isEmpty()) {
			System.out.println("Email null");
			HttpSession session = request.getSession();
			email = (String) session.getAttribute("email");
			if (email != null && !email.isEmpty()) {
				logged = true;
			}
		} else {
			logged = dao.loginCheck(email, password);
		}
		if (logged) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			User user = dao.getUser(email);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			CreateHtml html = new CreateHtml(user.getFname(), user.getLname(), email, user.getContact());
			out.write(html.getHtml());
			out.close();
		} else {
			System.out.println("Failed");
			response.sendRedirect("index.html");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
