<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<main>
	<!-- add file button -->		
	<button type ="button" class="btn btn-outline-primary add-file">
		<i class="material-icons">note_add</i>
	</button>
	<!-- upload file -->
	<div class="row">			
		<!-- search nav -->
		<div class="col search-nav">
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
			</form>			
		</div>
	</div>		   

	<div class="row">
		<!-- category -->		
		<div class="col-2 category">
			<h6 class="title">category</h6>		
			<ul class="nav nav-pills flex-column">
			  <li class="nav-item">
			    <a class="nav-link active" href="#">category 1</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">category 2</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">category 3</a>
			  </li>				  
			</ul>			
		</div>
		<!-- file list -->
		<div class="col-10">
			<div class="container">
				<div class="row">
					<div class="card-deck">
					  <div class="card">
					    <img class="card-img-top file">
					    
					    <div class="card-body">
					      <h5 class="card-title">File title 1</h5>
					      <p class="card-text">File 1.</p>
					      <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
					    </div>
					  </div>
					  <div class="card">
					    <img class="card-img-top file">
					    <div class="card-body">
					      <h5 class="card-title">File title 2</h5>
					      <p class="card-text">File 2.</p>
					      <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
					    </div>
					  </div>					 
					</div>	
				</div>
			</div>										
		</div>
	</div>
</main>