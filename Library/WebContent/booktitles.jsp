<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		ArrayList<String> bookTitlesList = (ArrayList<String>) request.getAttribute("books_titles_list");
	%>
	<ol>
		<%
			for (String title : bookTitlesList) {
		%>
		<li><a class='book-title' data-toggle='modal' href='#'><%=title%></a>
		    <a class='form-pull-right book-delete <%= title %>' href='#'>delete</a>
		    <a href='#' class='form-pull-right book-edit <%= title %>'>edit</a>
		</li>
		<%
			}
		%>

	</ol>
</body>
</html>