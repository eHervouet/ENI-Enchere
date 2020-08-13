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
				<h1 style="text-decoration : underline;"><fmt:message key="txt.his_profile"></fmt:message></h1>
				
				<div class="label"><fmt:message key="txt.pseudo"></fmt:message> : </div>${utilisateur.pseudo}<br/><br/>
				
				
				<div class="label"><fmt:message key="txt.lastname"></fmt:message> : </div>
				${utilisateur.nom}<br/><br/>
				
				<div class="label"><fmt:message key="txt.name"></fmt:message> : </div>
				${utilisateur.prenom}<br/><br/>
				
				<div class="label"><fmt:message key="txt.email"></fmt:message> : </div>
				${utilisateur.email}<br/><br/>
								
				<div class="label"><fmt:message key="txt.phone"></fmt:message> : </div>
				${utilisateur.telephone}<br/><br/>
								
				<div class="label"><fmt:message key="txt.street"></fmt:message> : </div>
				${utilisateur.rue}<br/><br/>
								
				<div class="label"><fmt:message key="txt.city"></fmt:message> : </div>
				${utilisateur.ville}<br><br/>
								
				<div class="label"><fmt:message key="txt.postcode"></fmt:message> : </div>
				${utilisateur.code_postal}<br/><br/>	
			</div>
			
			<div class="col-6">
				<h1 style="text-decoration : underline;"><fmt:message key="txt.his_sales"></fmt:message></h1>
				<ul>
					<c:forEach var="article" items="${la}">
				 		<li><a href="/ENI-Enchere/detailVente?no_article=${article.getNo_article()}">${article.date_debut_encheres} : ${article.nom_article}</a></li>
					</c:forEach>
				</ul>
				
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>