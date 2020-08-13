<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}" />
<fmt:setBundle basename="domaine.properties.langue"/>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.1/css/flag-icon.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<c:choose>
	<c:when test="${empty sessionScope.utilisateur.pseudo }">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="/ENI-Enchere/accueil">
			  	<img src="images/logo.ico" alt="logo eni-encheres" width="30" height="30" class="d-inline-block align-top"/>ENI-Encheres
			  </a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
				<ul class="navbar-nav mr-auto">
					<li>
					  <a class="nav-link" href="/ENI-Enchere/connexion"><fmt:message key="txt.login"></fmt:message></a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/creationCompte"><fmt:message key="txt.create_account"></fmt:message></a>
				  	</li>
			 	</ul>
			 	<ul class="navbar-nav">
       				<li>
					  	<div class="nav-item dropdown">
					  		<c:choose>
								<c:when test="${empty sessionScope.langue }">
									<a class="nav-link dropdown-toggle" href="/ENI-Enchere/choixlangue?langue=fr" id="dropdown09" data-toggle="dropdown"
	                    				aria-haspopup="true" aria-expanded="false"><span class="flag-icon flag-icon-fr"></span>
	                    			</a>
								</c:when>
								<c:otherwise>
									<a class="nav-link dropdown-toggle" href="/ENI-Enchere/choixlangue?langue=${sessionScope.langue}" id="dropdown09" data-toggle="dropdown"
	                    				aria-haspopup="true" aria-expanded="false"><span class="flag-icon flag-icon-${sessionScope.langue}"></span>
	                    			</a>	
								</c:otherwise>
							</c:choose>
	                		
	                		<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown09">
	                    		<a class="dropdown-item" href="/ENI-Enchere/choixlangue?langue=fr"><span class="flag-icon flag-icon-fr"> </span> Français</a>
	                    		<a class="dropdown-item" href="/ENI-Enchere/choixlangue?langue=ro"><span class="flag-icon flag-icon-ro"> </span> Română</a>
	                		</div>
	            		</div>
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
					  <a class="nav-link" href="/ENI-Enchere/MesEncheres"><fmt:message key="txt.auction"></fmt:message></a>
					</li>
					<li>
					  <a class="nav-link" href="/ENI-Enchere/ajoutVente"><fmt:message key="txt.sell_item"></fmt:message></a>
					</li>
					<li>
					  <a class="nav-link" href="/ENI-Enchere/profil">${sessionScope.utilisateur.pseudo}</a>
					</li>
					<li>  
					  <a class="nav-link" href="/ENI-Enchere/deconnexion"><fmt:message key="txt.disconnect"></fmt:message></a>
				  	</li>
			 	</ul>
			 	<ul class="navbar-nav">
       				<li> 
					  	<div class="nav-item dropdown">
	                		<c:choose>
								<c:when test="${empty sessionScope.langue }">
									<a class="nav-link dropdown-toggle" href="#	" id="dropdown09" data-toggle="dropdown"
	                    				aria-haspopup="true" aria-expanded="false"><span class="flag-icon flag-icon-fr"></span>
	                    			</a>
								</c:when>
								<c:otherwise>
									<a class="nav-link dropdown-toggle" href="#	" id="dropdown09" data-toggle="dropdown"
	                    				aria-haspopup="true" aria-expanded="false"><span class="flag-icon flag-icon-${sessionScope.langue}"></span>
	                    			</a>	
								</c:otherwise>
							</c:choose>
	                		<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown09">
	                    		<a class="dropdown-item" href="/ENI-Enchere/choixlangue?langue=fr"><span class="flag-icon flag-icon-fr"> </span> Français</a>
	                    		<a class="dropdown-item" href="/ENI-Enchere/choixlangue?langue=ro"><span class="flag-icon flag-icon-ro"> </span> Română</a>
	                		</div>
	            		</div>
            		</li>
    			</ul>
		</nav>
	</c:otherwise>
</c:choose>