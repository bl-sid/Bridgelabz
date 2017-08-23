

function onSubmitClick(){
	var email = document.getElementById("emailid").value;
	var password = document.getElementById("passid").value;
	var atposition = email.indexOf("@");
	var dotposition = email.indexOf(".");
	var lengthOfString = email.length;
	if(checkEmail(email)){
		alert("Invalid Email Address");
		return false;
	}
	if (password.length < 8){
		alert("Password is too short");
		return false;
	}
	
	return true;
}

function checkEmail(email){
	var atposition = email.indexOf("@");
	var dotposition = email.indexOf(".");
	var lengthOfString = email.length;
	if((atposition <= 1) || ((dotposition+1) <= atposition) || ((dotposition+1) == lengthOfString)){
		return true;
	}
	else{
		return false;
	}
}

function onSignUpClick(){
	var fname = document.getElementById("fname").value;
	if(fname.length < 3){
		alert("First name should have at least 3 characters");
		return false;
	}

	var lname = document.getElementById("lname").value;
	if(lname.length < 3){
		alert("Last name should have at least 3 characters");
		return false;
	}
	
	var email = document.getElementById("emailid").value;
	if(checkEmail(email)){
		alert("Invalid Email Address");
		return false;
	}
	
	var cno = document.getElementById("cno").value;
	if(isNaN(cno)){
		alert("Contact number should only contain numbers");
		return false;
	}
	if(cno.length != 10){
		alert("Contact number must have 10 digits");
		return false;
	}

	var password1 = document.getElementById("pass").value;
	if (password1.length < 8){
		alert("Password is too short");
		return false;
	}
	var password2 = document.getElementById("pass2").value;
	if(password1 != password2){
		alert("Passwords do not match");
		return false;
	}
}