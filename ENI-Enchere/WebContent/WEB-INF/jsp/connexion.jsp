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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>Connexion</title>
</head>
<body>
	<%@ include file="menu.jsp" %>	
 	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h2 style="text-decoration : underline;"><fmt:message key="txt.connection"></fmt:message></h2>
			</div>
		</div>
		<br/>
		<form method="POST" action="/ENI-Enchere/connexion">
			<div class="row">
				<div class="col-12 text-center">
					<label for="identifiant"><fmt:message key="txt.username"></fmt:message> :</label>
					<input type="text" name="identifiant" maxlength="30" required />
				</div>
			</div>
			<div class="row">
				<div class="col-12 text-center">
					<label for="identifiant"><fmt:message key="txt.password"></fmt:message> :</label>
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
			      	<button class="btn btn-success btn-lg" type="submit"><fmt:message key="txt.connection"></fmt:message></button>
			    </div>
			    <div class="col-4">
			      	<input type="checkbox" name="remember"><fmt:message key="txt.remember_me"></fmt:message><br/>
					<a href="jsp/RIP.jsp"><fmt:message key="txt.forgotten_password"></fmt:message> ?</a>
			    </div>
		  	</div>
		  	<br/>
		  	<div class="row justify-content-center">
			    <div class="col text-center">
			      	<button class="btn btn-success btn-lg" onclick="location.href='/ENI-Enchere/creationCompte';"><fmt:message key="txt.create_account"></fmt:message></button>
			    </div>
		  	</div>
		</form>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>