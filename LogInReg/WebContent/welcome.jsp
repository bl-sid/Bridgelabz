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
	
	<h2>Welcome <% Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("email")){
			out.println(cookie.getValue());
		}
	}
	 %></h2>
	
	<form action="fileupload.jsp" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple> <br><br>
		<input type="submit" value="Upload" class="submitid">
		
	<p> Number of people online are: <% 
		UserDao dao = new UserDao();
		out.println(dao.getCounter());
	%></p>
	
	<input type="submit" value="LogOut" formaction="LogOut" class="submitid">
	</form>
</body>
</html>