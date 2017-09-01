<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p id="para"></p>
<button >Hello</button>
<a id="mybtn" href="#">anchor</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#para").text("This is a para");
	},
	$("#mybtn").click(function(){
		var name = this.innerHTML;
		
		$.ajax({
			type : "post",
			url : "MyServlet",
			data : "name=" + name,
			success : function(data){
				$("#para").text(data);
			}
			
		});		
	})
	);
</script>
</body>
</html>