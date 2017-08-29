<%@page import="com.bridgelabz.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bridgelabz.LibraryDatabase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<title>Home</title>

<style type="text/css">
.nav-color {
	background-color: #C7CAD5;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-md nav-color">
	<div class="container-fluid">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">Username</li>
			<li class="nav-item"><a href="#">Logout</a></li>
		</ul>
	</div>
	</nav>


	<div class="container">
		<button class="btn btn-primary" type="button" data-toggle="modal"
			data-target="#science-data">Science</button>
		<button class="btn">Commerce</button>
		<button class="btn">Arts</button>
		<button class="btn">Add</button>
	</div>

<div class="modal fade" id="science-data" tabindex="-1">
	<div class="modal-dialog">
	<div class="modal-content">
	<div class="modal-header">Science</div>
	<div class="modal-body">
		<%
			LibraryDatabase db = new LibraryDatabase();
			ArrayList<Book> books = db.getScienceData();
			for(Book book: books){
				out.print("Name: " + book.getName());
				out.print("\tPrice: " + book.getPrice());
				out.print("\tCategory: " + book.getCategory() + "\n");
			}
		%>
	</div>
	</div>
	
	</div>

</div>
</body>
</html>