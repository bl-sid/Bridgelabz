<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>

<style>
.wrapper {
	width: 1000px;
	margin: auto;
	position: relative;
}

.left {
	border-right: 1px black solid;
	width: 35%;
	padding-right: 10px;
	margin: auto;
	margin-right: 10px;
	position: fixed;
	text-align: center;
	padding-bottom: 40px;
	font-size: 20px;
}

.right {
	float: right;
	width: 50%;
}

.fb {
	width: 230px;
	height: 30px;
	background-color: blue;
	color: white;
	font-size: 16px;
	background-color: blue;
}

.google {
	width: 230px;
	height: 30px;
	background-color: red;
	color: white;
	font-size: 16px;
}

input[type="email"] {
	font-size: 20px;
}

input[type="password"] {
	font-size: 20px;
	margin-top: 5px;
}

input[type="submit"] {
	background-color: aqua;
	font-size: 20px;
	margin: auto;
	margin-top: 15px;
	width: 255px;
	margin-top: 10px;
}

#signin{
	width:800px;
	margin:auto;
}
</style>
</head>
<body>
	<div id="signin">
		<h2>Sign In</h2>
		<hr>
	</div>

	<div class="wrapper">
		<div class="left">
			<h2>Use Other Accounts</h2>
			<p>You can also sign in using facebook or a google account</p>
			<button class="fb">Log In Using Facebook</button>
			<br> <br>
			<button class="google">Log In Using Google</button>
		</div>

		<div class="right">
			<h2>Using Your Account</h2>
			<form action="" method="post">
				<input type="email" name="email" placeholder="Enter Your Email ID">
				<br> <input type="password" name="password"
					placeholder="Enter Password"> <br> <input
					type="submit" value="Log In"> <br> <input
					type="submit" value="Register">
			</form>
		</div>
	</div>
</body>
</html>