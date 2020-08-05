<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<style>
	input, label {
    display:block;
}
</style>
<title>ENI-Enchere</title>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.identifiant }">
		<%
    		response.sendRedirect("ENI-Enchere/");
		%>
	</c:when>
	<c:otherwise>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/">ENI-Encheres</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="">Enchère</a>
					</li>
					<li>
					  <a class="nav-link" href="/ENI-Enchere/ajoutVente">Vendre un article</a>
					</li>
					<li>
					  <a class="nav-link" href="">${sessionScope.identifiant}</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/deconnexion">Déconnexion</a>
				  	</li>
			 	</ul>
		</nav>
	</c:otherwise>
</c:choose>
	
	<div class="container">
			<div class="row">
				<div class="col-12 text-center" style="margin-bottom:30px">
					<h2>Nouvelle Vente</h2>
				</div>
			<div class="col-md-3">
				<img id="preview" src="#" alt="votre image" width="200" height="200"/>
			</div>
			<div class="col-md-9">
				<form class="form-horizontal" method="POST" action="/ENI-Enchere/ajoutVente">
					<div class="form-group row">
	    				<label for="article" class="col-sm-2 col-form-label">Article :</label>
	    				<div class="col-sm-6">
	      					<input style="width:100%;" type="text" id="article" maxlength="30">
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="description" class="col-sm-2 col-form-label">Description :</label>
	    				<div class="col-sm-6">
	      					<textarea style="resize: vertical; width:100%; max-height: 200px; min-height: 75px;" type="text" id="description" maxlength="300"></textarea>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	  					<label for="categorie" class="col-sm-3 col-form-label">Catégorie :</label>
	  					<div class="col-sm-5">
							<select style="width:100%;" name="categories">
								<c:forEach var="cat" items="${listeCategories}">	
									<option value="${cat.no_categorie}">${cat.libelle}</option>	
								</c:forEach>
							</select>
						</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="photo" class="col-sm-3 col-form-label">Photo de l'article :</label>
	    				<div class="col-sm-5">
	    					<input type="file" id="photo" accept="image/png, image/jpeg">
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="prix" class="col-sm-3 col-form-label">Mise à prix :</label>
	    				<div class="col-sm-2">
	      					<input style="width:100%;" type="number" id="prix" min="1" value="1">
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="date_deb" class="col-sm-3 col-form-label">Début de l'enchère :</label>
	    				<div class="col-sm-5">
	      					<input style="width:100%;" name="date_deb" type="date">
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="date_fin" class="col-sm-3 col-form-label">Fin de l'enchère :</label>
	    				<div class="col-sm-5">
	      					<input style="width:100%;" name="date_fin" type="date">
	    				</div>
	  				</div>
	  				
	  				<div class="row">
						<div class="col-3">
							<input class="btn btn-success btn-lg" type="submit" value="Enregistrer">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
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

	$("#photo").change(function() {
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