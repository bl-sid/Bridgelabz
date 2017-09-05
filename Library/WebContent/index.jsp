<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap css link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<!-- Custom css link -->
<link rel="stylesheet" type="text/css" href="styles/login.css">

<title>Log In</title>

<!-- Custom javascript link -->
<script type="text/javascript" src="scripts/login.js"></script>

</head>
<body>

	<% 
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	// Redirects to homepage if already logged in
	String email = (String)session.getAttribute("email"); 
	if(email != null && !email.equals("")){
		response.sendRedirect("homepage.jsp");
	}
	%>

	<div class="container">
		<div class="row">
			<div class="col-lg-7 col-md-10 col-sm-12 col-xs-12 div-centered">
				<div class="page-header">
					<h1>Sign In</h1>
					<hr>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8 div-left">
						<h3>Use Other Accounts</h3>
						You can also sign in using your <br>Facebook Account or
						Google Account<br>

						<button type="button" class="btn btn-primary btn-fb">Login
							with Facebook</button>
						<br>
						<button type="button" class="btn btn-google">Login with
							Google</button>
					</div>
	
					
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8 div-right">
						<h3>Using Your Account</h3>
						<form action="LogIn" method="post">
							<div class="form-group">
								<input type="email" name="email" class="form-control myinput"
									placeholder="Enter Your Email ID" id="email">
							</div>

							<div class="form-group">
								<input type="password" name="password"
									class="form-control myinput" placeholder="Enter Password" id="password">
							</div>

							<div class="form-group">
								<input type="submit" value="Sign In"
									class="btn btn-primary form-control" onClick="return validateLogIn()">
							</div>
						</form>
						<a href="registration.jsp">New user? Create a new account</a>
						<br>
						<a href="#">Forgot your password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	

</body>
</html>