<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/detailVente.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<title>${articleEnchere.getNom_article()}</title>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.utilisateur.pseudo }">
		<%
    		response.sendRedirect("/ENI-Enchere/accueil");
		%>
	</c:when>
	<c:otherwise>
		<%@ include file="menu.jsp" %>	
	</c:otherwise>
</c:choose>
	
	<div class="container">
			<div class="row">
				<div class="col-12 text-center" style="margin-bottom:30px">
					<h2>Détails de la Vente</h2>
				</div>
			<div class="col-md-3">
				<img src="/uploaded/img/articles/${articleEnchere.getPath_photo()}" alt="image article" width="200" height="200">
			</div>
			<div class="col-md-9">
				<form method="post" action="" class="form-horizontal">
				
					<div class="form-group row">
	    				<label for="article" class="col-sm-3 col-form-label">Article :</label>
	    				<div class="col-sm-5">
	      					<p id="article">${articleEnchere.getNom_article()}</p>
	      					<input type="hidden" value="${articleEnchere.getNo_article()}" name="noarticle" />
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="description" class="col-sm-3 col-form-label">Description :</label>
	    				<div class="col-sm-5">
	      					<p>${articleEnchere.getDescription()}</p>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	  					<label for="categorie" class="col-sm-3 col-form-label">Catégorie :</label>
	  					<div class="col-sm-5">
							<p id="categorie">${articleEnchere.getLibelle()}</p>
						</div>
	  				</div>
	  				
	  				
	  				<div class="form-group row">
	    				<label for="prix" class="col-sm-3 col-form-label">Mise à prix :</label>
	    				<div class="col-sm-2">
	      					<p id="prix">${articleEnchere.getPrix_initial()}</p>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="date_deb" class="col-sm-3 col-form-label">Début de l'enchère :</label>
	    				<div class="col-sm-5">
							<p id="date_deb">${articleEnchere.getDate_debut_encheres()}</p>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="date_fin" class="col-sm-3 col-form-label">Fin de l'enchère :</label>
	    				<div class="col-sm-5">
	      					<p id="date_fin">${articleEnchere.getDate_fin_encheres()}</p>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="vendeur" class="col-sm-3 col-form-label">Vendeur :</label>
	    				<div class="col-sm-5">
	      					<p id="vendeur"><a href="/ENI-Enchere/voirVendeur?pseudo=${articleEnchere.getPseudo()}">${articleEnchere.getPseudo()}</a></p>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="proposition" class="col-sm-3 col-form-label">Ma proposition :</label>
	    				<div class="col-sm-5">
	      					<input name="proposition" type="number" min="${articleEnchere.getMontant_enchere()+1}" value="${articleEnchere.getMontant_enchere()}"> <!-- METTRE ICI LA VALEUR DE L'ENCHERE LA PLUS HAUTE -->
	      					<input  id="sendForm" type="submit" value="Enchérir">
	    				</div>
	  				</div>
	  				
	  				
	  				<fieldset>
  						<legend>Retrait</legend>
  						<div class="form-group row">
							<label for="rue" class="col-sm-3 col-form-label">Rue :</label>
	    					<div class="col-sm-5">
	      						<p id="rue">${sessionScope.utilisateur.rue}</p>
	    					</div>
	    				</div>
	    				<div class="form-group row">
							<label for="cp" class="col-sm-3 col-form-label">Code postal :</label>
	    					<div class="col-sm-5">
	      						<p id="cp">${sessionScope.utilisateur.code_postal}</p>
	    					</div>
	    				</div>
	    				<div class="form-group row">
							<label for="ville" class="col-sm-3 col-form-label">Ville :</label>
	    					<div class="col-sm-5">
	      						<p id="ville">${sessionScope.utilisateur.ville}</p>
	    					</div>
	    				</div>
 					</fieldset>
					<br><br>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>

<script>
//affichage de l'image upload
function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      $('#preview').attr('src', e.target.result);
	    }
	    
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
	}

	$("#photoAUploader").change(function() {
	  readURL(this);
	});
	
	$( document ).ready(function() {
		//set la valeur et le min pour les input de date et début et fin
		var today = new Date().toISOString().split('T')[0];
		var temp = new Date();
		temp.setDate(temp.getDate() + 1);
		var tomorrow = temp.toISOString().split('T')[0];
		
		document.getElementsByName("date_deb")[0].setAttribute('min', today);
		document.getElementsByName("date_deb")[0].setAttribute('value', today);
		
		document.getElementsByName("date_fin")[0].setAttribute('min', tomorrow);
		document.getElementsByName("date_fin")[0].setAttribute('value', tomorrow);
		
		
	});
	
	
</script>
</html>