package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setIntHeader("Refresh", 1);
		response.setContentType("text/html");
		
		Calendar calendar = Calendar.getInstance();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		if(calendar.get(Calendar.AM_PM) == 0){
			am_pm = "AM";
		} else{
			am_pm = "PM";
		}
		String time = hour + " : " + minute + " : " + second + " " + am_pm;
		PrintWriter out = response.getWriter();
		out.println(time);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
