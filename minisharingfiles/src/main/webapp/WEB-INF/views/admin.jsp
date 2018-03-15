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
<link rel="icon" href="<c:url value="/resources/image/icon.png"/>">
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
	<form name="body" class="col-6 inline-form center">
		<!-- content -->
		<div class="container-fluid margin-top-60">
			<!-- search nav -->
			<div class="row shadow-bottom margin-bottom-15 padding-search-bar">
				<form name="search">
					<div class="input-group">
						<input class="form-control" type="text" placeholder="Search"
							name="username">
						<button class="btn btn-outline-primary margin-left-8"
							type="submit">Search</button>
					</div>
				</form>
				<div class="example">
					<div class="container">
						<div class="row">

							<table class="table table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Email</th>
										<th>level</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${listUser}">
										<a href="admin/${user.getIdUser()}">
											<form name="deleteupdate" action="" method="post">
												<tr>
													<td>${user.getIdUser()}</td>
													<input class="hide_input" name="id"
														value="${user.getIdUser()}" />
													<td name="nameUser">${user.getNameUser()}</td>
													<td>${user.getEmailUser()}</td>
													<td>${user.getIdLevel().getIdLevel()}</td>
													<td><input type="submit" value="delete" /></td>
													<td><a
														href="<c:url value="admin/${user.getIdUser()}"/>">update</a></td>

												</tr>
											</form>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
		</div>
	</form>
	<!-- footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>