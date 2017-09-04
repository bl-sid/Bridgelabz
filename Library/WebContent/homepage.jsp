<%@page import="com.bridgelabz.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bridgelabz.LibraryDatabase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
	
<!-- Font awesome link -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">

<!-- Custom css file link -->
<link rel = "stylesheet" type="text/css" href = "styles/homepage.css">

<title>Home</title>

</head>

<body>

<%

// Setting page to reload and not open from browser caches

response.setHeader("Cache-Control", "no-cache");

//Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store");

//Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0);

//Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache");
//HTTP 1.0 backward enter code here


//If not logged in redirects to log in page
String email = (String)session.getAttribute("email"); 
if(email == null || email.equals("")){
	response.sendRedirect("index.jsp");
}
%>

<!-- Navigation bar -->
<nav class="navbar navbar-expand-md nav-color">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Library</a>
		</div>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><%=session.getAttribute("email") + "&nbsp;&nbsp;&nbsp;&nbsp;"%></li>
			<li class="nav-item" id="btn-logout"><a href="#">Logout</a></li>
		</ul>
	</div>
</nav>


<div class="container container-margin-top">

	<!-- Container for buttons -->
	<div id="btn-container">
		<button class="btn btn-primary category" type="button">Science</button>
		<button class="btn btn-primary category" type="button">Commerce</button>
		<button class="btn btn-primary category" type="button">Arts</button>
		<button type="button" class="btn btn-primary btn-lg" id="btn-add"  data-target="#add-data"> <i class="fa fa-plus-square-o fa-2x" aria-hidden="true"></i></button>
	
	</div>	


		<!-- Pop up for display books titles and details -->
		<div class="modal fade" id="category-data" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header category-header"></div>
					<div class="modal-body category-books"></div>
					<div class="modal-footer">
					<button class="btn btn-primary btn-sm" id="btn-close">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Pop up to add new and edit book info -->
	<div class="modal fade" id="add-data" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
					<div class="modal-header add-header">
						<h4 class="modal-title">Add Book</h4>
					</div>

					<div class="modal-body">
						<div class="form-group">
							<input type="text" class="form-control" name="title"
								placeholder="Book Title" value="" id="title">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" name="author"
								placeholder="Author" value="" id="author">
						</div>

						<div class="form-group">

							<select name="category" id="categoryid" class="form-control">
								<option selected disabled value="Category">Category</option>
								<option value="Science">Science</option>
								<option value="Commerce">Commerce</option>
								<option value="Arts">Arts</option>
							</select>

						</div>

						<div class="form-group">
							<input type="number" class="form-control" name="price"
								placeholder="Price" value="" id="price">
						</div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-primary btn-sm"
							data-dismiss="modal">Cancel</button>
						<input type="submit" class="btn btn-primary btn-sm" value="Save" id="btn-save">
					</div>
			</div>
		</div>
	</div>

	<!-- Jquery, Ajax link -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Bootstrap jquery links -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>


	<!-- Custom javascript link -->
	<script type="text/javascript" src="scripts/homepage.js">
		
	</script>

</body>
</html>