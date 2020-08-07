<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<title>Mon profil</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h2 style="text-decoration : underline;">Mon profil</h2>
				<label for="pseudo">Pseudo : </label><br/>
				<input type="text" name="pseudo" maxlength="30" value="${sessionScope.utilisateur.pseudo}" disabled/><br/><br/>
				
				<label for="nom">Nom : </label><br/>
				<input type="text" name="nom" maxlength="30" value="${sessionScope.utilisateur.nom}" disabled /><br/><br/>
				
				<label for="prenom">Prenom : </label><br/>
				<input type="text" name="prenom" maxlength="30" value="${sessionScope.utilisateur.prenom}" disabled /><br/><br/>
				
				<label for="email">Email : </label><br/>
				<input type="text" name="email" maxlength="20" value="${sessionScope.utilisateur.email}" disabled /><br/><br/>
				
				<label for="telephone">Téléphone : </label><br/>
				<input type="text" name="telephone" maxlength="15" value="${sessionScope.utilisateur.telephone}" disabled /><br/><br/>
				
				<label for="rue">Rue : </label><br/>
				<input type="text" name="rue" maxlength="30" value="${sessionScope.utilisateur.rue}" disabled /><br/><br/>
				
				<label for="ville">Ville : </label><br/>
				<input type="text" name="ville" maxlength="30" value="${sessionScope.utilisateur.ville}" disabled /><br/><br/>
				
				<label for="code_postal">Code postal : </label><br/>
				<input type="text" name="code_postal" maxlength="10" value="${sessionScope.utilisateur.code_postal}" disabled /><br/><br/>
				
				<label for="credit">Crédit : </label><br/>
				<input type="text" name="credit" value="${sessionScope.utilisateur.credit}" disabled />
			</div>
		</div>
	</div>
</body>
</html>