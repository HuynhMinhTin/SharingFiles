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

<link href="<c:url value="/resources/css/layout-header-footer.css" />"
	rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="header.jsp"%>

	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row" style="margin-top: 16px">
			<div class="col-sm-4 col-md-4">
				<img class="img_width"
					src='<c:url value="/resources/image/fileImage.jpg"/>' />
				<br><br><br>
				<form  method="post" >
				<%-- <input class="hide_input"  name="idFileDelete" value="${fileDetail.getIdFile() }" /> --%>
				<a href='<c:url value="delete-${fileDetail.getIdFile() }"/>'>				
					<%-- <input class="hide_input"  name="idUserDelete" value="${fileDetail.getIdUser() }" /> --%>
					<input type="submit" value="Delete" id="btn_delete" class="edit_delete">
				</a>
				</form>
			</div>
			 
			<div class="col-sm-8 col-md-8">
				<div class="col">
					<h3 class="title">FILE : ${kindFile } </h6>
					<h5 class="col-title" value="name">NAME : ${fileDetail.getNameFile()}</h5>
					<p class="col-text" value="size">Size: ${fileDetail.getSizeFile()} Bytes</p>
					<p class="col-text" value="category">Category: ${fileDetail.getIdCategory().getNameCategory()}</p>
					<p class="col-text" value="uploader">Uploader:${fileDetail.getIdUser().getIdUser()} ${fileDetail.getIdUser().getNameUser()} </p>
					<p class="col-text" value="comment">Comment: ${fileDetail.getCommentFile()} </p>
				</div>
				<div>
					<p>
					<a href='<c:url value="/home/download/${fileDetail.getIdFile() }"/>'>
						<input type="button" value="Download" id="btn_download"> 
					</a>
						
						<input
							type="button" value="Update" id="btn_update">
						
					</p>
				</div>
			</div>
		</div>
	</div>
	

	<form action="" method="post" id="file_form" class="hide_form_update">
	<table>
		<tr>
			<th>Name</th>
			<th>Category</th>
			<th>Comment</th>
			<th>Descirption</th>
		</tr>
		<tr>
			<td>
			 <input rows="4" cols="50"  type="text" name="nameUpdate">
			</td>
			<br>
			<td >
					<c:forEach var="cate" items="${category }">		
							<input type="radio" name="categoryUpdate" value="${cate.getIdCategory()}"
							/> ${cate.getNameCategory()}
							<br>
					</c:forEach>
			</td>
			<td>
			
					<textarea rows="4" cols="50" name="commentUpdate" form="file_form" > </textarea>
					<br>
			</td>
			<td>
					<textarea rows="4" cols="50" name="descriptionUpdate" form="file_form" > </textarea>
					<br>
			</td>
			<br>
		</tr>
		<br>
		
	</table>
	<br>
	<input type="submit" value="Update" />
	</form>


	
	<!-- footer -->
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
		
	<script src='<c:url value="/resources/js/login.js"/>'></script>
	<script src='<c:url value="/resources/js/login.js"/>'></script>
	
</body>
</html>