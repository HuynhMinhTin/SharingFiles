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
<link rel="icon" href="resources/image/icon.png">
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
				<div class="input-group">
					<input class="form-control" type="text" placeholder="Search"
						name="username">
					<button class="btn btn-outline-primary margin-left-8" type="submit">Search</button>
				</div>
				<div class="example">
					<div class="container">
						<div class="row">

							<table class="table table-striped">
								<thead>
									<tr>
										<th>STT</th>
										<th>Name</th>
										<th>Email</th>
										<th>level</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${listUser}">
										<tr>
											<td name="id">${user.getIdUser()}</td>
											<td>${user.getNameUser()}</td>
											<td>${user.getEmailUser()}</td>
											<td>
												<div class="quantity buttons_added">
													<input type="number" step="1" min="1" max="3"
														name="quantity" title="Qty" class="input-text qty text"
														size="4" pattern="[0-9]*" inputmode="numeric"
														value="${user.getIdLevel().getIdLevel()}" />

												</div>
											</td>
										 	<td>
										 			
  													   <input type="submit" value="Delete" action = "/admin/delete/${user.getIdUser()}"/>
													
           									
       						 				</td>
										


										</tr>
									</c:forEach>
								</tbody>
								</table>
						</div>
					</div>
					</div>
			</form>
		</div>
	</div>


	<script>
function deleteRow(btn) {
  var row = btn.parentNode.parentNode;
  row.parentNode.removeChild(row);
}
</script>
	<!-- footer -->
	<%@ include file="footer.jsp"%>`x
</body>
</html>