<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: #35D4D1;
}

.block {
	background-color: white;
	padding: 10px;
	padding-bottom: 1px;
	margin: auto;
	margin-top: 5px;
}

.inputs {
	border-radius: 5px;
	background-color: #F7F4F3;
	font-size: 20px;
}

#register-button {
	text-align: center;
	background-color: green;
	color: white;
	margin: 0 auto;
}

#last-line {
	text-align: center;
	margin-top: 10px;
}

#para {
	border-style: dashed;
	border-color: #808080;
	border-radius: 10px;
	padding: 5px;
}

.btn-background {
	
}
</style>

</head>
<body>


	<div class="container">

		<div class="row">

			<div class="col-lg-4 col-md-6 col-sm-8 col-xs-8 block">

				<h1>Create An Account</h1>
				<hr>
				<form action="">

					<div class="form-group">
						<label for="name">Full Name:</label> <input type="text"
							class="form-control" id="name">
					</div>

					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" id="email">
					</div>

					<div class="form-group">
						<label for="mobno">Contact Number:</label> <input type="tel"
							class="form-control" id="mobno">
					</div>
					Gender: <label class="radio-inline"> <input type="radio"
						name="gender"> Male
					</label> <label class="radio-inline"> <input type="radio"
						name="gender"> Female
					</label>

					<div class="form-group">
						<label for="password">New Password:</label> <input type="password"
							class="form-control" id="password">
					</div>
					<p id="para">
						By Clicking on the "Create an account" button below, you certify
						that you have read and agreed to our <a href="#">terms of use</a>
						and <a href="#">privacy policy<a>
					</p>
					<center>
						<input type="submit" value="Create An Account"
							class="inputs btn-background text-center" id="register-button">
					</center>
				</form>
				<br>
				<p id="last-line">
					Already have an account? <a href="index3.jsp">Sign in.</a>
				</p>

			</div>

		</div>

	</div>
</body>
</html>