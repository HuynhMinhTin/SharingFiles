<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update</title>
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
							<form name="update" action="admin/update/${user.getIdUser()}"
								method="get">
								<table>
								<a href="admin/${user.getIdUser()}">
										<tr>
											<td>ID</td>
											<td>${user.getIdUser()}</td>
											<input class="hide_input" name="id"
												value="${user.getIdUser()}" />
										</tr>

										<tr>
											<td>NAme:</td>
											<td><input type="text" name="nameUser"
												value="${user.getNameUser()}"></td>
										</tr>
										<tr>
											<td>emailUser:</td>
											<td><input name="emailUser"
												value="${user.getEmailUser()}"></td>
										</tr>
										<tr>
											<td>Level</td>
											<td>
												<div class="quantity buttons_added">
													<input type="number" step="1" min="1" max="3" title="Qty"
														size="4" value="${user.getIdLevel().getIdLevel()}" />

												</div>
											</td>
										</tr>


										<tr>
											<td colspan="2" align="center"><input type="submit"
												value="Update"></td>
										</tr>
								</table>
							</form>
							<div></div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</form>



	<!-- footer -->
	<%@ include file="footer.jsp"%>`x
</body>
</html>