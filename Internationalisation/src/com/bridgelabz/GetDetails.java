package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetDetails")
public class GetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Locale locale = request.getLocale();
		String country = locale.getCountry();
		String lang = locale.getLanguage();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<h1> Locale </h1>");
		out.print("<h2> Country: " + country + "<br>Language: "
				+ lang + " </h2>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
