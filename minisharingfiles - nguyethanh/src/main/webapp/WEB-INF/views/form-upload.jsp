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
<link href="<c:url value="resources/css/layout-header-footer.css" />"
	rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="header.jsp"%>
	
	<!-- upload form -->
    <main class="container center">
        <form action="">
            <div class="form-group">
                <label for="category">Category</label>       
                <select class="form-control" name="category" id="category">          
                    <option value="Book">Book</option>
                    <option value="Study">Study</option>
                    <option value="Work">Work</option>
                    <option value="Picture">Picture</option>
                    <option value="Video">Video</option>
                    <option value="Music">Music</option>
                </select>            
            </div>        
            <div class="form-group">
                <label for="status">Status</label>
                <div id="status">
                    <div class="custom-control custom-radio custom-control-inline">
                      <input type="radio" id="rad-public" name="status" class="custom-control-input" value="public">
                      <label class="custom-control-label" for="rad-public">Public</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                      <input type="radio" id="rad-private" name="status" class="custom-control-input" value="private">
                      <label class="custom-control-label" for="rad-private">Private</label>
                    </div>
                </div>            
            </div>
            <div class="form-group">
                <label for="descript">Description</label>
                <textarea class="form-control" rows="3" id="descript"></textarea>
            </div>            
            <button class="btn btn-primary" type="file">Chosse Image</button>            
        </form>
    </main>    
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
</body>
</html>