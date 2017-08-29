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
<title>Sign In</title>

<style type="text/css">
.div-centered {
	margin: 0 auto;
	border: 1px #AAACB2 solid;
	border-radius: 10px;
	margin-top: 50px;
	padding: 10px;
}

.btn-google {
	background-color: #131417;
	color: white;
	margin-top: 15px;
}

.div-left {
	border-right: 1px solid grey;
	text-align: center;
}

.div-right {
	text-align: center;
}

.btn-fb {
	margin-top: 15px;
}
</style>
</head>
<body>

	<div class="container">
		

		<div class="row">
			<div class="col-md-8 div-centered">
			<h1>Sign In</h1>
				<hr>

				<div class="row">
					<div class="col-md-6 div-left">
						<h3>Use Other Accounts</h3>
						You can also sign in using your <br>Facebook Account or
						Google Account<br>

						<button type="button" class="btn btn-primary btn-fb">Login
							with Facebook</button>
						<br>
						<button type="button" class="btn btn-google">Login with
							Google</button>
					</div>


					<div class="col-md-6 div-right">
						<h3>Using Your Account</h3>
						<form action="">
							<div class="form-group">
								<input type="email" name="email" class="form-control myinput"
									placeholder="Enter Your Email ID">
							</div>

							<div class="form-group">
								<input type="password" name="password"
									class="form-control myinput" placeholder="Enter Password">
							</div>

							<div class="form-group">
								<input type="submit" value="Sign In"
									class="btn btn-primary form-control">
							</div>
						</form>


						
							<a href="#">Forgot your password?</a>
						
					</div>


				</div>
			</div>
		</div>




	</div>
</body>
</html>