<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/voirVendeur.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<title>${utilisateur.pseudo}</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1 style="text-decoration : underline;">Mon profil</h1>
				
				<div class="label">Pseudo : </div>${utilisateur.pseudo}<br/><br/>
				
				
				<div class="label">Nom : </div>
				${utilisateur.nom}<br/><br/>
				
				<div class="label">Prenom : </div>
				${utilisateur.prenom}<br/><br/>
				
				<div class="label">Email : </div>
				${utilisateur.email}<br/><br/>
								
				<div class="label">Telephone : </div>
				${utilisateur.telephone}<br/><br/>
								
				<div class="label">Rue : </div>
				${utilisateur.rue}<br/><br/>
								
				<div class="label">Ville : </div>
				${utilisateur.ville}<br><br/>
								
				<div class="label">Code postal : </div>
				${utilisateur.code_postal}<br/><br/>	
			</div>
			
			<div class="col-6">
				<h1 style="text-decoration : underline;">Mes ventes</h1>
				<ul>
					<c:forEach var="article" items="${la}">
				 		<li>${article.date_debut_encheres} : ${article.nom_article}</li>
					</c:forEach>
				</ul>
				
			</div>
		</div>
	</div>
</body>
</html>