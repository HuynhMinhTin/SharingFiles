<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini File Sharing</title>
<!-- icon for Web -->
<link rel="icon" href="resources/image/icon.png">
<link href="<c:url value="/resources/css/registry.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/login.js" />"></script>


</head>
<body>
	<div class="panel-wrapper">
		<div class="feature-panel--enterprise">
			<h2 id="enterprise-panel__header" style="pading_top: 330px;">

				<small id="enterprise-panel__subheader">Thông Tin Các Thành
					Viên</small><br> Nhóm Siêu Quậy Tí Hon
			</h2>
			<p id="enterprise-panel__caption">Master Design. in class
				desinger fresher</p>


			<a href="https://www.dxc.technology/" target="_blank"
				class="enterprise-panel__button"
				style="border: 1px solid rgb(255, 51, 102); background: none; color: rgb(255, 51, 102); visibility: visible;">Learn
				More</a>

			<div class="enterprise-panel__footer">
				<p>
					TRUSTED BY THE WORLD'S SMARTEST COMPANIES <br> My group Slogan
				</p>
			</div>

		</div>
		<div class="main-panel">
			<div class="main-panel__table">
				<div class="main-panel__table-cell">
					<div class="main-panel__switch">
						<span class="main-panel__switch__text">Already have an
							account?</span> <a class="main-panel__switch__button" href="login">Sign
							in</a>
					</div>
					<div class="main-panel__content">
						<form class="main-panel__form" method="post">
							<h1>Create your Files Sharing Account</h1>
							<div class="form__page sign-up">
								<div class="form__group">
									<label for="email" class="form__label">Email Address</label> <input
										type="text" class="form__input validate-empty"
										name="email_form_signup" placeholder="phu1@gmail.com" value>
									<div class="alert alert-error alert-email"
										style="display: none">Please enter your email address.</div>
								</div>
								<div class="form__group">
									<label for="name" class="form__label">Name</label> <input
										type="text" class="form__input validate-empty"
										name="name_form_signup" placeholder="quang phu" value>
									<div class="alert alert-error alert-name" style="display: none">Please
										enter your full name</div>
								</div>
								<div class="form__group">
									<label for="password" class="form__label">Password</label> <input
										type="password" class="form__input validate-empty"
										name="password_form_signup" placeholder="5+ characters" value>
									<div class="alert alert-error alert-password"
										style="display: none">Your password must be at least 6
										characters long</div>
								</div>
								<div class="form__group">
									<label for="password" class="form__label">Confirm
										Password</label> <input type="password"
										class="form__input validate-empty" name="confirmpassword"
										aria-invalid="true">
									<div class="alert alert-error alert-passwordAgain"
										style="display: none">Your password doesn't match.</div>
								</div>
							</div>
							<div class="text--center">
								<button type="submit" class="form__button sign-up__submit"
									id="btn_form_signup">Continue</button>
							</div>
						</form>
						<span class="span_result">${checkUserSignUp}</span>
						<p class="form__legal">
							By click continue I agree to Files Sharing's rule.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>