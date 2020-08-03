<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>ENI-Enchere</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="/ENI-Enchere/">ENI-Encheres</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
		<ul class="navbar-nav mr-auto">
			<li>
			  <a class="nav-link" href="">Se connecter</a>
			</li>
			<li>  
			  <a class="nav-link" href="">Créer un compte</a>
		  	</li>
	 	</ul>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="col">
				<h2 style="text-align : center; text-decoration : underline;">Liste des enchères</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<select name="categories">
					<option value=""></option>
					<c:forEach var="cat" items="${listeCategories}">
								
									<option value="${cat.no_categorie}">${cat.libelle}</option>
								
					</c:forEach>
				</select>
			</div>
			<div class="col">
			</div>
		</div>	
	</div>
	
	
</body>
</html>