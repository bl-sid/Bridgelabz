<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<style type="text/css">
.buttons {
	color: white;
	font-size: 16px;
	border-radius: 5px;
	padding: 10px;
}

#fb {
	background-color: #022B7E;
	padding-left: 20px;
	padding-right: 20px;
	margin-top: 10px;
}

#google {
	margin-top: 5px;
	background-color: #131417;
	padding-left: 30px;
	padding-right: 27px;
}

.first-div {
	border-right: black solid;
	text-align:center;
	padding-right: 50px;
}


.myinput{
	width: 50%;
}

.mylink{
	width:50%;
	text-align:center;
}

.second-col{
	padding-left:50px;
}



.para-right{
	text-align: center;
}

</style>
</head>
<body>

	<div class="container">

		<h1>Sign In</h1>
		<hr>
		<div class="row">
			<div class="col-md-6 first-div">
			<span class="float-right">
				<h3>Use Other Accounts</h3>
				<div class="para-right">
					You can also sign in using your <br>Facebook Account or Google
				Account<br>
				</div>

				<button id="fb" class="buttons">Login with Facebook</button>
				<br>
				<button id="google" class="buttons">Login with Google</button>
			</span></div>
			
			<div class="col-md-6 second-col">
				<h3>Using Your Account</h3>
				<form action="">
				<div class="form-group">
					<input type="email" name="email" class="form-control myinput" placeholder="Enter Your Email ID">
				</div>
				
				<div class="form-group">
					<input type="password" name="password" class="form-control myinput" placeholder="Enter Password">
				</div>
				
				<div class="form-group">
					<input type="submit" value="Sign In" class="btn btn-primary form-control myinput">
				</div>
				</form>
				
				
				<p class="mylink"><a href="#">Forgot your password?</a></p>
			</div>

		</div>
	</div>
</body>
</html>