<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<header class="header">
		<div class="container">
			<div class="row">
				<div class="col">					
					<i class="material-icons brand">cloud_done</i>	
				</div>			
				<div class="col-md-8 col-sm-7 direction">				
					<ul class="nav">						
						<li class="nav-item">
							<a class="nav-link active" href="">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="">Link 1</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="">Link 2</a>
						</li>					  
					</ul>				
				</div>	
				<div class="col-md-3 col-sm-4">
				
				
				<c:choose>
					<c:when test="${message  != null }">
						<ul style="list-style: none;">
						<div class="name_header col-md-6 col-sm-6" >
							<a class="circle-avartar" href=""><span>${message }</span></a>
							 <a class="" href=""><span>${emailUser }</span></a>
						</div>
						</ul>
						
					</c:when>
					<c:otherwise>
						<div class="nav justify-content-end registry-guest">
						<li class="nav-item">
							<a class="nav-link" href="login">Login</a>
						</li>					
						<li class="nav-item">
							<a class="nav-link" href="register">Register</a>
						</li>	
					</div>
					
					</c:otherwise>
				</c:choose>
							
				</div>				
			</div>
		</div>		
		
	</header>