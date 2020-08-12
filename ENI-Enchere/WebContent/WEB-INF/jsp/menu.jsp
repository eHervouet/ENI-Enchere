<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty sessionScope.utilisateur.pseudo }">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/accueil">
			  	<img src="images/logo.ico" alt="logo eni-encheres" width="30" height="30" class="d-inline-block align-top"/>ENI-Encheres
			  </a>			
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="/ENI-Enchere/connexion">Se connecter</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/creationCompte">Cr�er un compte</a>
				  	</li>
			 	</ul>
		</nav>
	</c:when>
	<c:otherwise>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/accueil">
			  	<img src="images/logo.ico" alt="logo eni-encheres" width="30" height="30" class="d-inline-block align-top"/>ENI-Encheres
			  </a>
			
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="/ENI-Enchere/MesEncheres">Ench�re</a>
					</li>
					<li>
					  <a class="nav-link" href="/ENI-Enchere/ajoutVente">Vendre un article</a>
					</li>
					<li>
					  <a class="nav-link" href="/ENI-Enchere/profil">${sessionScope.utilisateur.pseudo}</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/deconnexion">D�connexion</a>
				  	</li>
			 	</ul>
		</nav>
	</c:otherwise>
</c:choose>