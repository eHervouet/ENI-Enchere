<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<title>Creation de compte</title>
</head>
<body>
	<%@ include file="menu.jsp" %>	
 	
	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h2 style="text-decoration : underline;">Création de compte</h2>
			</div>
		</div>
		<form method="POST" action="/ENI-Enchere/creationCompte" class='form-horizontal'>
			<div class="row">
				<div class="col-6">
					<label for="pseudo">Pseudo : </label><br/>
					<input type="text" name="pseudo" maxlength="30" required />
				</div>
				<div class="col-6">
					<label for="email">Email : </label><br/>
					<input type="text" name="email" maxlength="20" required />
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="nom">Nom : </label><br/>
					<input type="text" name="nom" maxlength="30" required />
				</div>
				<div class="col-6">
					<label for="telephone">Téléphone : </label><br/>
					<input type="text" name="telephone" maxlength="15" required />
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="prenom">Prenom : </label><br/>
					<input type="text" name="prenom" maxlength="30" required />
				</div>
				<div class="col-6">
					<label for="rue">Rue : </label><br/>
					<input type="text" name="rue" maxlength="30" required />
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="mot_de_passe">Mot de passe : </label><br/>
					<input type="password" name="mot_de_passe" maxlength="30" required />
				</div>
				<div class="col-6">
					<label for="ville">Ville : </label><br/>
					<input type="text" name="ville" maxlength="30" required />
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<label for="mot_de_passe_confirmation">Confirmation : </label><br/>
					<input type="password" name="mot_de_passe_confirmation" maxlength="30" required />
				</div>
				<div class="col-6">
					<label for="code_postal">Code postal : </label><br/>
					<input type="text" name="code_postal" maxlength="10" required />
				</div>
			</div>
			<br/>
			<div class="row justify-content-center">
		  		<div class="col text-center">
		  			<span style="color : red; text-decoration : underline;">${error}</span>
		  		</div>
		  	</div>
			<div class="row">
				<div class="col-6">
					<input class="btn btn-success btn-lg" type="submit" value="Créer mon compte">
				</div>
				<div class="col-6">
					<button class="btn btn-danger btn-lg" type="button" onclick="location.href='/ENI-Enchere/accueil';" formnovalidate>Annuler</button>
				</div>
			</div>				
		</form>
	</div>
	
</body>
</html>