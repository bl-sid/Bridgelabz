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
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">

<title>Home</title>

<style type="text/css">

.nav-color {
	background-color: #C7CAD5;
}

/* #btn-add {
	position: fixed;
	bottom: 100px;
	right: 100px;
} */

.form-pull-right {
	float: right;
	margin-right: 15px;
}

#btn-container{
	margin: auto;
}

.container-margin-top {
	margin-top: 10px;
}

</style>
</head>
<body>

<%

response.setHeader("Cache-Control", "no-cache");

//Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store");

//Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0);

//Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache");
//HTTP 1.0 backward enter code here



String email = (String)session.getAttribute("email"); 
if(email == null || email.equals("")){
	response.sendRedirect("index.jsp");
}
%>

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

	<div id="btn-container">
		<button class="btn btn-primary category" type="button">Science</button>
		<button class="btn btn-primary category" type="button">Commerce</button>
		<button class="btn btn-primary category" type="button">Arts</button>
		<button type="button" class="btn btn-primary btn-lg" id="btn-add"  data-target="#add-data"> <i class="fa fa-plus-square-o fa-2x" aria-hidden="true"></i></button>
	
	</div>	


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


	<div></div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


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



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			
			var titleName = "";
			$('.category').click(function() {
				var category = this.innerHTML;

				$.ajax({
					type : "get",
					url : "BookTitleLoader",
					data : "category=" + category,
					success : function(data) {
						$('.category-header').html(category + " Books");
						$('.category-books').html(data);
						$('#category-data').modal('show');
						refreshClickEvent();
					}
				});
			});

			$('#btn-close').click(function(){
				$('#category-data').modal('hide');
			});
			
			$('#btn-add').click(function(){
				$('.add-header').html("Add Book");
				$('#title').val("");
				$('#author').val("");
				$('#categoryid').val("Category");
				$('#price').val("");
				titleName = "";
				$('#add-data').modal('show'); 
			});
			
			$('#btn-save').click(function(){
				 if(!$('#title').val()){
					alert("Title field is empty");
				} else if(!$('#author').val()){
					alert("Author field is empty");
				}  else if(!$('#categoryid').val()){
					alert("Please select the category of the book");
				}  else if(!$('#price').val()){
					alert("Price field is empty");
				} else{	 			
					$.ajax({
						type : "post",
						url : "AddNewBook",
						data: {
							title : $('#title').val(),
							author : $('#author').val(),
							category : $('#categoryid').val(),
							price : $('#price').val(),
							oldTitle : titleName
						},
						success : function(data) {
							$('#add-data').modal('hide');
							titleName = "";
						}
					});
				}
				
			});
			
			$('#btn-logout').click(function(){
				$.ajax({
					type : "post",
					url : "LogOut",
					success : function(data){
						window.location = data;
					}
				});
			});
			
			function refreshClickEvent() {

				$("body .book-title").off();

				$("body .book-title").on("click", function() {
					var bookname = $(this).text();

					$.ajax({
						type : "get",
						url : "BookDetailsLoader",
						data : "title=" + bookname,
						success : function(data) {
							$('.category-header').html(bookname);
							$('.category-books').html(data);
						}
					});
				});
				
				
				$("body .book-edit").off();

				$("body .book-edit").on("click", function() {
					var bookname = $(this).attr('class');
					bookname = bookname.replace("form-pull-right book-edit ", "");
					$.ajax({
						type : "get",
						url : "EditBook",
						dataType : "json",
						data : "title=" + bookname,
						success : function(data) {
							titleName = data.title;
							$('.add-header').html("Edit Book");
							$('#title').val(data.title);
							$('#author').val(data.author);
							$('#categoryid').val(data.category);
							$('#price').val(data.price);
							$('#category-data').modal('hide');
							$('#add-data').modal('show'); 
						}
					});
				});
				
				
				$("body .book-delete").off();

				$("body .book-delete").on("click", function() {
					var bookname = $(this).attr('class');
					bookname = bookname.replace("close book-delete ", "");
					$.ajax({
						type : "get",
						url : "DeleteBook",
						data : "title=" + bookname,
						success : function(data) {
							$('#category-data').modal('hide');
						}
					});
				});
			}
		});
	</script>

</body>
</html>