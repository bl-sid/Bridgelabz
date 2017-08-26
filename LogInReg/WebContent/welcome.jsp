<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.bridgelabz.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<style> 
	.submitid{
		background-color:orange;
		color:white;
		font-size:20px;
	}
</style>
</head>
<body>

	<%! UserDao dao = null; 
	boolean increase = false;%>
	<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	Cookie[] cookies = request.getCookies();
	if(cookies.length != 0){
		increase = true;
	}
	for(Cookie cookie : cookies){
		if(cookie.getValue() == null || cookie.getValue().isEmpty()){
			increase = true;
		}
	}
	
	Cookie cookie = new Cookie("email", email);
	
	User user = new User(email, password);
	
	dao = new UserDao();
	
	dao.registerUser(user);
	%>
	
	<h2>Welcome <%= email %></h2>
	
	<form action="" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple> <br><br>
		<input type="submit" value="Upload" class="submitid" action="">
		
	<p> Number of people online are: <% 
		int counter = dao.getCounter();
		if(increase){
			counter++;
			dao.updateCounterInDatabase(counter);
		} 
		out.println(counter);
	%></p>
	
	<input type="submit" value="LogOut" formaction="LogOut" class="submitid">
	</form>
</body>
</html>