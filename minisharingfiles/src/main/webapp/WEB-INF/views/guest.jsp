<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Mini File Sharing</title>
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
<link href="<c:url value="/resources/css/layout-header-class.css" />"
	rel="stylesheet">
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
						name="filename">
					<div class="input-group-append">
						<input class="btn btn-outline-primary rounded-right" type="button"
							value="Customize" data-toggle="modal"
							data-target="#customize-search" aria-haspopup="true"
							aria-expanded="false">
					</div>
					<button class="btn btn-outline-primary margin-left-8" type="submit">Search</button>
				</div>
				<!-- customize search -->
				<div id="customize-search" class="modal fade" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="dropdown">
								<div class="form-group">
									<label for="category">Category</label> <select id="category"
										name="orderby" class="form-control">
										<option value="book">Book</option>
										<option value="music">Music</option>
										<option value="video">Video</option>
										<option value="picture">Picture</option>
										<option value="program">Program</option>
										<option value="study">Study</option>
										<option value="work">Work</option>
									</select>
								</div>
								<div class="form-group">
									<label for="uploader">Uploader</label> <input type="text"
										class="form-control" name="uploader" id="uploader"
										placeholder="Uploader...">
								</div>
								<div class="form-group">
									<label for="size">Size</label> <select name="size"
										class="form-control">
										<option value="30">from 0mb to 30mb</option>
										<option value="40">from 30mb to 40mb</option>
										<option value="60">from 41mb to 60mb</option>
										<option value="80">from 61mb to 80mb</option>
										<option value="81">81mb or more</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

		<div class="container-fluid">
			<div class="row">
				<!-- category -->
				<div class="col-md-2 col-sm-4 category">
					<h6 class="title">category</h6>
					<ul class="nav nav-pills flex-column">
						<!-- <li class="nav-item"><a class="nav-link active">Book</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Music</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Video</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Picture</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Program</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Study</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Work</a></li> -->
						<c:forEach var="cate" items="${category }">
								<li class="nav-item">
								<a class="nav-link active" href= '<c:url value="cate-${cate.getIdCategory()}"/>'> ${cate.getNameCategory()}
								</a>
								</li>
					</c:forEach>
					</ul>
				</div>

				<!--cai bang  -->
				<div class="example">
					<div class="container">
						<div class="row">
							<table class="table table-striped">

								<tr>
									<th name="id">IdFile</th>
									<th name="idUser">idUser</th>
									<th name="namefile">nameFile</th>
									<th name="sizefile">sizeFile</th>
									<th name="commentfile">commentFile</th>
									<th name="datagreatefile">dateGreateFile</th>
									
									
								<tr>
									<c:forEach var="file" items="${listFiles}">
									 <tr>
									 <th name="id">${file.getIdFile()}</th>
									<th name="idUser">${file.getIdUser().getNameUser()}</th>
									 <th name="namefile">${file.getNameFile()}</th>
									 <th name="sizefile">${file.getSizeFile()}</th>
									 <th name="commentfile">${file.getCommentFile()}</th>
									<th name="datagreatefile">${file.getDateCreateFile()}</th>
									 
									 </tr>
									
									</c:forEach>
							
						
							</table>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

	<!-- bootstrap css, jQuery 4 -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<!-- angular 1.6.4 -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

	<script src="<c:url value="/resources/js/image-file.js" />"></script>
	<script src="<c:url value="/resources/js/itialize-status.js" />"></script>
</body>
</html>