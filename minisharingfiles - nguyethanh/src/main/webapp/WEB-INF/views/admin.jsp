<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<!-- Google icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- icon for Web -->
<link rel="icon" href="../image/icon.png">
<!-- font -->
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
<!-- bootstrap 4 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- customize bootstrap -->
<link rel="stylesheet" href="resources/css/layout-header-footer.css">
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
							<h2>Table Striped</h2>
							<table class="table table-striped">
								<thead>
									<tr>
										<th name="id">STT</th>
										<th name="username">Họ Tên</th>
										<th name="emailuser">Email</th>
										<th>level</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Văn Cường</td>mail
										<td>sssaadart@mail.com</td>
										<td>
											<div class="quantity buttons_added">
												<input type="number" step="1" min="1" max="3"
													name="quantity" value="1" title="Qty"
													class="input-text qty text" size="4" pattern="[0-9]*"
													inputmode="numeric">
											</div>
										</td>
										<td><input type="button" value="Delete"
											onclick="deleteRow(this)" /></td>
									</tr>
									<tr>
										<td>2</td>
										<td>Hoài Minh</td>
										<td>hoaiminhit1990@mail.com</td>
										<td>
											<div class="quantity buttons_added">
												<input type="number" step="1" min="1" max="3"
													name="quantity" value="1" title="Qty"
													class="input-text qty text" size="4" pattern="[0-9]*"
													inputmode="numeric">
											</div>
										</td>
										<td><input type="button" value="Delete"
											onclick="deleteRow(this)" /></td>

									</tr>
									<tr>
										<td>3</td>
										<td>Quốc Minh</td>
										<td>quocminh@mail.com</td>
										<td>
											<div class="quantity buttons_added">
												<input type="number" step="1" min="1" max="3"
													name="quantity" value="1" title="Qty"
													class="input-text qty text" size="4" pattern="[0-9]*"
													inputmode="numeric">
											</div>
										</td>
										<td><input type="button" value="Delete"
											onclick="deleteRow(this)" /></td>

									</tr>
									<tr>
										<td>3</td>
										<td>Huy Phong</td>
										<td>phongalibaba@mail.com</td>
										<td>
											<div class="quantity buttons_added">
												<input type="number" step="1" min="1" max="3"
													name="quantity" value="1" title="Qty"
													class="input-text qty text" size="4" pattern="[0-9]*"
													inputmode="numeric">
											</div>
										</td>
										<td><input type="button" value="Delete"
											onclick="deleteRow(this)" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>				
			</form>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="footer.jsp" %>>
</body>
</html>