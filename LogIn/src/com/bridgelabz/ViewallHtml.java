package com.bridgelabz;

import java.util.Iterator;
import java.util.LinkedList;

public class ViewallHtml {
	
	String createHtml(LinkedList<User> users) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"\n" + 
				"<head>\n" + 
				"<title> All Users </title>\n" + 
				"<meta charset = \"utf-8\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>\n" + 
				"<ul>\n");
		
		Iterator<User> iterater = users.iterator();
		while(iterater.hasNext()) {
			User user = iterater.next();
			
			builder.append("<li> Name: " + user.getFname() + " " 
					+ user.getLname() + "</li>");
			builder.append("<li> Email ID: " + user.getEmail() + "</li>");
			builder.append("<li> Contact: " + user.getContact() + "</li>");
			builder.append("<hr>");
		}
		builder.append("</ul>\n" + 
				"</li>\n" + 
				"</body>\n" + 
				"</html>");
		
		return builder.toString();
	}
}
