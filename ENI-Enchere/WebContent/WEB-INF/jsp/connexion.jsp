<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<title>Connexion</title>
</head>
<body>
	<%@ include file="menu.jsp" %>	
 	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h2 style="text-decoration : underline;">Connexion</h2>
			</div>
		</div>
		<br/>
		<form method="POST" action="/ENI-Enchere/connexion">
			<div class="row">
				<div class="col-12 text-center">
					<label for="identifiant">Identifiant :</label>
					<input type="text" name="identifiant" maxlength="30" required />
				</div>
			</div>
			<div class="row">
				<div class="col-12 text-center">
					<label for="identifiant">Mot de passe :</label>
					<input type="password" name="mot_de_passe" maxlength="30" required />
				</div>
			</div>
			<div class="row justify-content-center">
		  		<div class="col text-center">
		  			<span style="color : red; text-decoration : underline;">${err}</span>
		  		</div>
		  	</div>
			<div class="row justify-content-center">
			    <div class="col-4" style="text-align: right;">
			      	<button class="btn btn-success btn-lg" type="submit">Connexion</button>
			    </div>
			    <div class="col-4">
			      	<input type="checkbox" name="remember"> Se souvenir de moi<br/>
					<a href="jsp/RIP.jsp">Mot de passe oublié ?</a>
			    </div>
		  	</div>
		  	<br/>
		  	<div class="row justify-content-center">
			    <div class="col text-center">
			      	<button class="btn btn-success btn-lg" onclick="location.href='/ENI-Enchere/creationCompte';">Créer un compte</button>
			    </div>
		  	</div>
		</form>
	</div>
</body>
</html>