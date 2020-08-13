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
			<form method="POST" action="/ENI-Enchere/modifierProfil">
					<h2 style="text-decoration : underline;"><fmt:message key="txt.my_profile"></fmt:message></h2>
					<label for="pseudo"><fmt:message key="txt.pseudo"></fmt:message> : </label><br/>
					<input type="text" name="pseudo" maxlength="30" value="${sessionScope.utilisateur.pseudo}" disabled required/><br/><br/>
					
					<label for="nom"><fmt:message key="txt.lastname"></fmt:message> : </label><br/>
					<input type="text" name="nom" maxlength="30" value="${sessionScope.utilisateur.nom}" disabled required/><br/><br/>
					
					<label for="prenom"><fmt:message key="txt.name"></fmt:message> : </label><br/>
					<input type="text" name="prenom" maxlength="30" value="${sessionScope.utilisateur.prenom}" disabled required/><br/><br/>
					
					<label for="email"><fmt:message key="txt.email"></fmt:message> : </label><br/>
					<input type="text" name="email" maxlength="20" value="${sessionScope.utilisateur.email}" disabled required/><br/><br/>
					
					<label for="telephone"><fmt:message key="txt.phone"></fmt:message> : </label><br/>
					<input type="text" name="telephone" maxlength="15" value="${sessionScope.utilisateur.telephone}" disabled required/><br/><br/>
					
					<label for="rue"><fmt:message key="txt.street"></fmt:message> : </label><br/>
					<input type="text" name="rue" maxlength="30" value="${sessionScope.utilisateur.rue}" disabled required/><br/><br/>
					
					<label for="ville"><fmt:message key="txt.city"></fmt:message> : </label><br/>
					<input type="text" name="ville" maxlength="30" value="${sessionScope.utilisateur.ville}" disabled required/><br/><br/>
					
					<label for="code_postal"><fmt:message key="txt.postcode"></fmt:message> : </label><br/>
					<input type="text" name="code_postal" maxlength="10" value="${sessionScope.utilisateur.code_postal}" disabled required/><br/><br/>
					
					<label for="credit"><fmt:message key="txt.credit"></fmt:message> : </label><br/>
					<input type="number" name="credit" value="${sessionScope.utilisateur.credit}" disabled /><br/><br/>
					
					<div class="row justify-content-center">
				  		<div class="col text-center">
				  			<span style="color : red; text-decoration : underline;">${error}</span>
				  		</div>
		  			</div><br/><br/>
					<input type="hidden" name="no_utilisateur" value="${sessionScope.utilisateur.no_utilisateur}" />
					<button type="button" class="btn btn-secondary" id="modifier"><fmt:message key="txt.update"></fmt:message></button>
					<button type="button" class="btn btn-secondary" id="annuler" onclick="location.href='/ENI-Enchere/profil'"><fmt:message key="txt.cancel"></fmt:message></button>
					<button type="submit" class="btn btn-success" id="enregistrer" disabled><fmt:message key="txt.save"></fmt:message></button><br/>
				</form>
				<form method="POST" action="/ENI-Enchere/suppressionUtilisateur">
					<input type="hidden" name="no_utilisateur" value="${sessionScope.utilisateur.no_utilisateur}" />
					<button type="submit" class="btn btn-danger" id="supprimer" onclick="location.href='/ENI-Enchere/suppressionUtilisateur'"><fmt:message key="txt.delete"></fmt:message></button>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#annuler").hide();
  $("#modifier").click(function(){
  	$("input:text").prop("disabled", false);
    $("#enregistrer").prop("disabled", false);
    $("#modifier").hide();
    $("#annuler").show();
  });
});
</script>
</html>