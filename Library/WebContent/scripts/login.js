
function validateLogIn(){
	var email = document.getElementById("email").value;
	var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regEx.test(email);
	
	var password = document.getElementById("password").value;
	if(password.length < 8){
		alert("Password must be at least 8 characters long");
		return false;
	}
	
	return true;
}