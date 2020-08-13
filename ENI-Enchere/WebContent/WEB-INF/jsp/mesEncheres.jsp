<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mesEncheres.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>Mes Enchères</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-6">
				<h2>Mes ventes</h2>
				<c:forEach var="aev" items="${laev}">
					 <div class="item">
					 	<div class="fill">
					 		<img src="${pageContext.request.contextPath}/photos_articles/${aev.path_photo}" alt="image article">
					 	</div>
				 		<div class="text">
				 			<ul id="filter">
				 				<li class="title"style="text-decoration: underline; list-style-type: none;">${aev.nom_article}</li>
				 				<li>Échéance : ${aev.date_fin_encheres}</li>
				 				<li>Prix initial : ${aev.prix_initial}</li>
				 				<li>Prix de départ : ${aev.prix_vente}</li>
				 				<li>Dernière enchère : ${aev.montant_enchere} <br/>par : <a href="/ENI-Enchere/voirVendeur?pseudo=${aev.pseudo}">${aev.pseudo}</a></li>
							</ul>
				 		</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-6">
				<h2>Mes enchères</h2>
				<c:forEach var="ae" items="${lae}">
					 <div class="item">
					 	<div class="fill">
					 		<img src="${pageContext.request.contextPath}/photos_articles/${ae.path_photo}" alt="image article">
					 	</div>
				 		<div class="text">
				 			<ul id="filter">
				 				<li class="title"style="text-decoration: underline; list-style-type: none;">${ae.nom_article}</li>
				 				<li>Vendu par : <a href="/ENI-Enchere/voirVendeur?pseudo=${um.getUtilisateurByNum(ae.getNo_utilisateur()).getPseudo()}">${um.getUtilisateurByNum(ae.getNo_utilisateur()).getPseudo()}</a></li>
				 				<li>Échéance : ${ae.date_fin_encheres}</li>
				 				<li>Prix initial : ${ae.prix_initial}</li>
				 				<li>Prix de départ : ${ae.prix_vente}</li>
				 				<li>J'ai enchéri à : ${ae.montant_enchere}</li>
							</ul>
				 		</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>