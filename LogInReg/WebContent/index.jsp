<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	form {
		width: 250px;
		margin : auto;
		margin-top: 150px;
		border: 1px black solid;
		padding: 20px;
	}
</style>
</head>
<body>
	
	<form>
		<h2>Sign In</h2>
		<table>
			<tr>
				<th>Email ID: </th>
				<td><input type="email" name="email" placeholder="Email ID"></td>
			</tr>
			<tr>
				<th>Password: </th>
				<td><input type="password" name="password" placeholder="Password"></td>			
			</tr>
		</table>
		
		<input type="submit" value="Log In">
	</form>
</body>
</html>