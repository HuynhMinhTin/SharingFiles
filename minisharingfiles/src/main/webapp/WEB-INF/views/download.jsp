<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<!-- Google icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- icon for Web -->
<link href=" <c:url value="/resources/image/icon.png" />" rel="icon">
<!-- font -->
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
<!-- bootstrap 4 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- customize bootstrap -->
<link href="<c:url value="/resources/css/layout-header-footer.css" />"
	rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="header.jsp"%>

	<!-- content -->
	<div class="container-fluid margin-top-60">
		<!-- search nav -->
		<div class="row shadow-bottom margin-bottom-15 padding-search-bar">
			<form class="col-6 inline-form center">

				<div class="container">
					<div class="row">
						<div class="container-fluid text-center">
							<h6 class="title">FILE</h6>
							<div class="row">
								<div class="col">
									<h5 class="col-title" value="name">Name:</h5>
									<p class="col-text" value="size">Size:</p>
									<p class="col-text" value="category">Category:</p>
									<p class="col-text" value="uploader">Uploader:</p>
								</div>
							</div>
							<div class="row center">
								<input class="btn btn-primary" type="button" value="DOWNLOAD">
							</div>
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="alert alert-primary" role="alert">
		${message}
	</div>
	<!-- footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>