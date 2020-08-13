<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ajoutVente.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<title>ENI-Enchere</title>
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
			<div class="col-md-12">
				<h2 style="text-align : center; text-decoration : underline; margin-bottom:50px"><fmt:message key="txt.new_sale"></fmt:message></h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 pr-0 pl-0">
				<img id="preview" src="#" alt="<fmt:message key="txt.item_photo"></fmt:message>" width="240" height="240"/>
			</div>
			<div class="col-md-9">
				<form class="form-horizontal" method="POST" action="/ENI-Enchere/ajoutVente" enctype="multipart/form-data">
					<div class="form-group row">
	    				<label for="article" class="col-sm-2 col-form-label"><fmt:message key="txt.item"></fmt:message> :</label>
	    				<div class="col-sm-6">
	      					<input style="width:100%;" type="text" name="article" maxlength="30" required>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="description" class="col-sm-2 col-form-label"><fmt:message key="txt.description"></fmt:message> :</label>
	    				<div class="col-sm-6">
	      					<textarea style="resize: vertical; width:100%; max-height: 200px; min-height: 75px;" type="text" name="description" maxlength="300" required></textarea>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	  					<label for="categorie" class="col-sm-3 col-form-label"><fmt:message key="txt.category"></fmt:message> :</label>
	  					<div class="col-sm-5">
							<select style="width:100%;" name="categories">
								<c:forEach var="cat" items="${listeCategories}">	
									<option value="${cat.no_categorie}">${cat.libelle}</option>
								</c:forEach>
							</select>
						</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="photoAUploader" class="col-sm-3 col-form-label"><fmt:message key="txt.item_photo"></fmt:message> :</label>
	    				<div class="col-sm-5">
	    					<input type="file" id="photoAUploader" name="photoAUploader" accept="image/png, image/jpeg"  required>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="prix" class="col-sm-3 col-form-label"><fmt:message key="txt.opening_bid"></fmt:message> :</label>
	    				<div class="col-sm-2">
	      					<input style="width:100%;" type="number" name="prix" min="0" value="0" required>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="date_deb" class="col-sm-3 col-form-label"><fmt:message key="txt.auction_start_date"></fmt:message> :</label>
	    				<div class="col-sm-5">
	      					<input style="width:100%;" name="date_deb" type="date" required>
	    				</div>
	  				</div>
	  				
	  				<div class="form-group row">
	    				<label for="date_fin" class="col-sm-3 col-form-label"><fmt:message key="txt.auction_end_date"></fmt:message></label>
	    				<div class="col-sm-5">
	      					<input style="width:100%;" name="date_fin" type="date" required>
	    				</div>
	  				</div>
	  				
	  				<fieldset>
  						<legend>Retrait</legend>
  						<div class="form-group row">
							<label for="rue" class="col-sm-3 col-form-label"><fmt:message key="txt.street"></fmt:message> :</label>
	    					<div class="col-sm-5">
	      						<input style="width:100%;" type="text" id="rue" maxlength="30" value="${sessionScope.utilisateur.rue}" required>
	    					</div>
	    				</div>
	    				<div class="form-group row">
							<label for="cp" class="col-sm-3 col-form-label"><fmt:message key="txt.postcode"></fmt:message> :</label>
	    					<div class="col-sm-5">
	      						<input style="width:100%;" type="text" id="cp" maxlength="15" value="${sessionScope.utilisateur.code_postal}" required>
	    					</div>
	    				</div>
	    				<div class="form-group row">
							<label for="ville" class="col-sm-3 col-form-label"><fmt:message key="txt.city"></fmt:message> :</label>
	    					<div class="col-sm-5">
	      						<input style="width:100%;" type="text" id="ville" maxlength="30" value="${sessionScope.utilisateur.ville}" required>
	    					</div>
	    				</div>
 					</fieldset>
	  				
	  				<div class="row">
						<div class="col-3">
							<input class="btn btn-success btn-lg" type="submit" value="<fmt:message key="txt.save"></fmt:message>">
						</div>
						<div class="col-3">
							<input class="btn btn-success btn-lg" type="reset" value="<fmt:message key="txt.cancel"></fmt:message>">
						</div>
					</div>	
					<br><br>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajoutVente.js"></script>
</html>