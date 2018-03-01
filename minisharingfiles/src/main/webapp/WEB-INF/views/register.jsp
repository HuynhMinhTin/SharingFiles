    
 <%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
    
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>




<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


	 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/login.js" />"></script> 


</head>
<body>

<div class="panel-wrapper">
        <div  class = "feature-panel--enterprise">
            <h2 id="enterprise-panel__header"  style="pading_top: 330px;">
                
            <small id="enterprise-panel__subheader">Thông Tin Các Thành Viên</small><br>
                Nhóm Siêu Quậy Tí Hon
            </h2>
            <p id="enterprise-panel__caption"> Master Design. in class desinger fresher</p>


            <a href="https://www.invisionapp.com/" target="_blank" class="enterprise-panel__button"  style="border: 1px solid rgb(255, 51, 102); background: none; color: rgb(255, 51, 102); visibility: visible;">Learn More</a>

            <div class="enterprise-panel__footer">
                <p>
                    TRUSTED BY THE WORLD'S SMARTEST COMPANIES <br>
                    My group Slogan
                </p>
            </div>

        </div>

        <div class="main-panel">
                <div class="main-panel__table">
                    <div class="main-panel__table-cell">
                        <div class="main-panel__switch">
                            <span class="main-panel__switch__text">Don't have an account?</span>
                            <a class="main-panel__switch__button">Get Started</a>
                        </div>
                        <div class="main-panel__content">
                                                     
	                           <div id ="formSignin">
				                       <h1 class="main-panel__heading">
			                            Sign in to Files Sharing.
			                            <small class="main-panel__subheading">Enter your details below.
			                                </small></h1>
			                            <form id="signinform" action="" method="post" novalidate>
			                                <div id="loginemail" class="form__group">
			                                    <label for="emailAddress" class="form__label">Email Address</label>
			                                    <input id="emailAddress" type="email" name="email" class="form__input" name="password" placeholder="as1@gmail.com" value>
			                                </div>
			                                <div id="loginpassword" class="form__group">
			                                    <label for="password" class="form__label">Password</label>
			                                    <input id="password" type="password" class="form__input" name="password" placeholder="Enter your password">
			                                    <a class="form__help">Forgot password?</a>
			                                </div>
                         				   <div class="text--center">
                                   				 <button id="login" class="form__button">Sign in</button>
                              				 </div>
                              				 <p id="two">Don't have account? <a  href="#"  id="singup">Sign up here</a></p>
                              				 
                              				 
                            			</form>
	                           
	                           </div>
	                           
	                           <div id ="formRegister">
	                           	
	                           	<h3>Create a Free Account</h3>
		                             <form id="form"  action="" method="post" novalidate>
	                             		<div  class="form__group">
		                                    <label for="emailAddress" class="form__label">Full Name</label>
		                                    <input id="name" type="email" name="email" class="form__input" name="password" placeholder="Name" value>
	                               		 </div>
		                                <div class="form__group">
		                                    <label for="emailAddress" class="form__label">Email Address</label>
		                                    <input id="emailAddress" type="email" name="email" class="form__input" name="password" placeholder="as1@gmail.com" value>
		                                </div>
		                                <div class="form__group">
		                                    <label for="password" class="form__label">Password</label>
		                                    <input  id="password" type="password" class="form__input" name="password" placeholder="Enter your password">
		                                 
		                                </div>
		                                 <div class="form__group">
		                                    <label for="password" class="form__label">Confirm Password</label>
		                                    <input id="confirmpassword" type="password" class="form__input" name="password" placeholder="Enter your password">
		                                </div>     
		                                
		                                   <div class="text--center">
                                    			<button id="register" class="form__button">Register</button>
                              			 </div>  
                              			 
                      
	                           		 </form>
		                           
	                           </div>
                            
                          
                        </div>
                    </div>
                </div>
        </div>
    </div>


</body>
</html>