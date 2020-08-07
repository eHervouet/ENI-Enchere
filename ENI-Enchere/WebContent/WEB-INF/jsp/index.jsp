<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<style>
	input, label {
    display:block;
}
</style>
<title>ENI-Enchere</title>
</head>
<body>
<%@ include file="menu.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col">
				<h2 style="text-align : center; text-decoration : underline;">Liste des enchères</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<label for="search">Filtres :</label>
				<input type="search" name="search" placeholder="Rechercher ..."><br/>
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
			<c:forEach var="articleEnchere" items="${listeArticleEncheres}">
			 <div class="col-lg-5" style="background-color : blue; color: white; margin: 15px; align: center;">
			 	<div class="row justify-content-center" style="">
			 		<div class="col-lg-3" style="background-color : red; color: white; margin: 15px; align: center;">
			 			<img class="fit-picture" src="<%=getServletContext().getRealPath("/")%>${articleEnchere.getPath_photo()}" alt="image article">
			 		</div>
			 		<div class="col-lg-7" style="background-color : green; color: white; margin: 15px; align: center;">
			 			<p style="text-decoration: underline;">${articleEnchere.getNom_article()}</p>
			 			<p>Prix : ${articleEnchere.getMontant_enchere()}</p>
			 			<p>Fin de l'enchère :  ${articleEnchere.getDate_fin_encheres()}</p>
			 			<p>Vendeur :  ${articleEnchere.getPseudo()}</p>
			 		</div>
			 	</div>
			</div>
		</c:forEach>	
		</div>
			
	</div>
	
</body>
</html>