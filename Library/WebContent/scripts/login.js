
function validateLogIn(){
	var email = document.getElementById("email").value;
	if(email.indexOf("@") < 2){
		alert("Invalid email address");
		return false;
	}
	if((email.indexOf(".") - email.indexOf("@")) < 2){
		alert("Invalid email address");
		return false;
	}
	if((email.length - email.indexOf(".")) < 2){
		alert("Invalid email address");
		return false;
	}
	
	var password = document.getElementById("password").value;
	if(password.length < 8){
		alert("Password must be at least 8 characters long");
		return false;
	}
	
	return true;
}