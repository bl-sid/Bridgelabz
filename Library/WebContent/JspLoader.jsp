<%@page import="com.bridgelabz.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bridgelabz.LibraryDatabase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<%
		String category = request.getParameter("category");
		LibraryDatabase database = new LibraryDatabase();
		ArrayList<Book> books = database.getCategoryData(category);
		out.print("<ol>");
		for (Book book : books) {
			out.print("<li>");
			out.print("<a class='book-title' data-toggle='modal' href='#'>" + book.getTitle() + "</a>");
			out.print("<button type='button' class='close' data-dismiss='modal'>&times;</button>");
			out.print("<a href='#' class='form-pull-right'>edit</a>");
			out.print("</li>");
		}
		out.print("</ol>");
	%>
</body>
</html>