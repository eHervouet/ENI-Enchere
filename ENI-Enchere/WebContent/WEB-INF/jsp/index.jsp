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
		</div><br />
		<div class="row justify-content-center" id="contenant">
			<c:forEach var="articleEnchere" items="${listeArticleEncheres}">
			 <div id="myDIV" class="col-lg-5" style="background-color : green; color: white; margin:10px 15px 10px 15px; border:solid grey;">
			 	<div class="row">
			 		<div class="col pl-0 pr-0 fill" style="width:200px; height:200px">
			 			<img src="${pageContext.request.contextPath}/photos_articles/${articleEnchere.getPath_photo()}" alt="image article">
			 		</div>
			 		<div class="col" style="color: white;">
			 			<ul id="filter">
			 				<li style="text-decoration: underline; list-style-type: none;"><span id="research">${articleEnchere.getNom_article()}</span></li>
			 				<li>Prix : ${articleEnchere.getMontant_enchere()}</li>
			 				<li>Fin de l'enchère :  ${articleEnchere.getDate_fin_encheres()}</li>
			 				<li id="num_cat" value="${articleEnchere.getNo_categorie()}"></li>
			 				<li>Vendeur :  <a href="/ENI-Enchere/voirVendeur?pseudo=${articleEnchere.getPseudo()}">${articleEnchere.getPseudo()}</a></li>
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
		     // $(this).closest("#myDIV").hide($(this).text().toLowerCase().indexOf(value) > -1);
		 });
	});
	
    $("#selectCat").change(function(){
        var num_categorie = $(this).children("option:selected").val();
        $("#myDIV #num_cat").filter(function() {	
        	$(this).closest("#myDIV").toggle($(this).val() == num_categorie || num_categorie == "all");
        	//$(this).closest("#myDIV").hide($(this).val() == num_categorie || num_categorie == "all");
    	});
    });
});
</script>
</html>