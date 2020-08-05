<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<style>
	input, label {
    display:block;
}
</style>
<title>ENI-Enchere</title>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.identifiant }">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/">ENI-Encheres</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="/ENI-Enchere/connexion">Se connecter</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/creationCompte">Créer un compte</a>
				  	</li>
			 	</ul>
		</nav>
	</c:when>
	<c:otherwise>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/">ENI-Encheres</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="">Enchère</a>
					</li>
					<li>
					  <a class="nav-link" href="">Vendre un article</a>
					</li>
					<li>
					  <a class="nav-link" href="">${sessionScope.identifiant}</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/deconnexion">Déconnexion</a>
				  	</li>
			 	</ul>
		</nav>
	</c:otherwise>
</c:choose>		
	<div class="container">
		<div class="row">
			<div class="col">
				<h2 style="text-align : center; text-decoration : underline;">Liste des enchères</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<label for="search">Filtres :</label>
				<input type="search" name="search" placeholder="Le nom de l'article contient"><br/>
				<label for="categorie">Catégorie :</label>
				<select name="categories">
					<option value="all">Toutes</option>
					<c:forEach var="cat" items="${listeCategories}">		
						<option value="${cat.no_categorie}">${cat.libelle}</option>	
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<button class="btn btn-success btn-lg" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button><br/>
			</div>
		</div><br />
		<div class="row justify-content-center" style="">
			<c:forEach var="article" items="${listeArticles}">
			 <div class="col-lg-5" style="background-color : blue; color: white; margin: 15px; align: center;">
			 	<div class="row justify-content-center" style="">
			 		<div class="col-lg-3" style="background-color : red; color: white; margin: 15px; align: center;">
			 			<img class="fit-picture" src="${article.getPath_photo()}" alt="image article">
			 		</div>
			 		<div class="col-lg-7" style="background-color : green; color: white; margin: 15px; align: center;">
			 			<p style="text-decoration: underline;">${article.getNom_article()}</p>
			 			<p>Prix : ${article.getPrix_initial()}</p>
			 			<p>Fin de l'enchère :  ${article.getDate_fin_encheres()}</p>
			 			<p>Vendeur :  ${article.getNo_utilisateur()}</p>
			 		</div>
			 	</div>
			</div>
		</c:forEach>	
		</div>
			
	</div>
	
</body>
</html>