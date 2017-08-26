<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>

<style>
input[type="email"] {
	font-size: 20px;
}

input[type="password"] {
	font-size: 20px;
	margin-top: 5px;
}

form{
	width:280px;
	margin:auto;
	margin-top:150px;
}
#titleid{
	font-size:30px;
	margin:auto;
	margin-bottom:10px;
}
#signup{
	font-size:25px;
	margin-left:80px;
	background-color:BurlyWood ;
	color:white;
	margin-bottom:10px;
}
</style>
</head>
<body>

	<form action="welcome.jsp" method="post">
	<fieldset>
	<legend id="titleid">Sign Up</legend>
		<input type="email" name="email" placeholder="Enter Email ID">
		<br>
		<br> <input type="password" name="password"
			placeholder="Create New Password"> <br>
		<br> <input type="password" name="password2"
			placeholder="Confirm Password"> <br>
		<br>
		<input type="submit" value="Sign Up" id="signup">
		</fieldset>
	</form>

</body>
</html>