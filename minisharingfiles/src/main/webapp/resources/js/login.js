$(document).ready(function() {

	$("#formRegister").hide();
// On Click SignIn Button Checks For Valid E-mail And All Field Should Be Filled
$("#login").click(function() {
	
	var email = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
	if ($("#loginemail") =='' || $("#loginpassword") == '') {
		alert("Please fill all fields...!!!!!!");
	} else if (!($("#loginemail")).match(email)) {
		alert("Please enter valid Email...!!!!!!");
	} else {
		alert("You have successfully Logged in...!!!!!!");
	}
});
$("#register").click(function() {
		var email = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i); // fomat email
		if ($("#name") == '' || $("#emailAddress") == '' || $("#password") == '' || $("#confirmpassword") == '') {
			alert("Please fill all fields...!!!!!!");
		} else if (!($("#emailAddress")).match(email)) {
			alert("Please enter valid Email...!!!!!!");
		} else if($("#password").val() != $("#confirmpassword").val() ){
			$("#name").val() == '' ; 
			$("#emailAddress").val() == '' ;
			$("#password").val() == '' ;
			$("#confirmpassword").val == '';
			alert("Password and Confirm password is wrong...!!!!!!");
		}
		
		
		else {
		
			$("#formSignin").show();
		}
});
// On Click SignUp It Will Hide Login Form and Display Registration Form
$("#signup").click(function() {
	$("#formSignin").hide();
	$("#formRegister").show();
});

});