<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty sessionScope.utilisateur.pseudo }">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/accueil">ENI-Encheres</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="/ENI-Enchere/connexion">Se connecter</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/creationCompte">Créer un compte</a>
				  	</li>
			 	</ul>
		</nav>
	</c:when>
	<c:otherwise>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/accueil">ENI-Encheres</a>
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
					  <a class="nav-link" href="/ENI-Enchere/profil">${sessionScope.utilisateur.pseudo}</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/deconnexion">Déconnexion</a>
				  	</li>
			 	</ul>
		</nav>
	</c:otherwise>
</c:choose>