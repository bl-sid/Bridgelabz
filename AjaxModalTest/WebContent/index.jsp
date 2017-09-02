<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<button>Hello</button>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('button').click(function(){
			$.ajax({
				type : "get",
				url : "MyServLet",
				success : function(data){
					document.write(data);
					RefreshSomeEventListener();
				}
			})
		});
	
		$('body').on('click', 'myclass', function() {
			$("body .myclass").on("click", function() {
		        alert("Clicked");
		    });
		});
		
		 function RefreshSomeEventListener() {
			alert("Hello");
		
		    // Remove handler from existing elements
		    $("body .myclass").off(); 

		    // Re-add event handler for all matching elements
		    $("body .myclass").on("click", function() {
		        alert("Clicked");
		    });
		} 
	});
</script>
</body>
</html>