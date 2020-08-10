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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
				<input id ="search" type="search" name="search" placeholder="Rechercher ..."><br/>
				<label for="categories">Catégorie :</label>
				<select id="selectCat"  name="categories">
					<option value="all">Toutes</option>
					<c:forEach var="cat" items="${listeCategories}">		
						<option  value="${cat.no_categorie}">${cat.libelle}</option>	
					</c:forEach>
				</select>
			</div>
			<div class="col">
				<button class="btn btn-success btn-lg" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button><br/>
			</div>
		</div><br />
		<div class="row justify-content-center" id="contenant">
			<c:forEach var="articleEnchere" items="${listeArticleEncheres}">
			 <div id="myDIV" class="col-lg-5" style="background-color : blue; color: white; margin: 15px; align: center;">
			 	<div class="row justify-content-center" style="">
			 		<div class="col-lg-3" style="background-color : red; color: white; margin: 15px; align: center;">
			 			<img class="fit-picture" src="${articleEnchere.getPath_photo()}" alt="image article">
			 		</div>
			 		<div class="col-lg-7" style="background-color : green; color: white; margin: 15px; align: center;">
			 			<ul id="filter">
			 				<li style="text-decoration: underline;"><span id="research">${articleEnchere.getNom_article()}</span></li>
			 				<li>Prix : ${articleEnchere.getMontant_enchere()}</li>
			 				<li>Fin de l'enchère :  ${articleEnchere.getDate_fin_encheres()}</li>
			 				<li>Vendeur :  ${articleEnchere.getPseudo()}</li>
			 				<li id="num_cat" >${articleEnchere.getNo_categorie()}</li>
			 			</ul>
			 		</div>
			 	</div>
			</div>
		</c:forEach>	
		</div>
			
	</div>
	
</body>
<script>
$(document).ready(function(){
	$("#search").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		 $("#myDIV #research").filter(function() {		 
		      $(this).closest("#myDIV").toggle($(this).text().toLowerCase().indexOf(value) > -1);
		 });
	});
	
    $("#selectCat").change(function(){
        var categorie = $(this).children("option:selected").val();
        console.log(categorie);
        $("#myDIV #num_cat").filter(function() {	
        	console.log($(this).text());
		      $(this).closest("#myDIV").toggle($(this).text() != categorie);
		 });
      });
	
});
</script>
</html>