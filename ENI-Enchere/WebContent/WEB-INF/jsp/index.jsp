<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
<script src="https://use.fontawesome.com/9de3b4962a.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>ENI-Enchere</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col">
				<h2 id="h2_index"><fmt:message key="txt.auction_list"></fmt:message></h2>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<label for="search"><fmt:message key="txt.filters"></fmt:message> :</label>
				<input id ="search" type="search" name="search" placeholder="<fmt:message key="txt.research"></fmt:message>"><br/>
				<label for="categories"><fmt:message key="txt.category"></fmt:message> :</label>
				<select id="selectCat"  name="categories">
					<option value="all"><fmt:message key="txt.all"></fmt:message></option>
					<c:forEach var="cat" items="${listeCategories}">		
						<option  value="${cat.no_categorie}">${cat.libelle}</option>	
					</c:forEach>
				</select>
			</div>
		</div><br />
		<div class="row justify-content-center" id="contenant">
			<c:forEach var="articleEnchere" items="${listeArticleEncheres}">
			 <div id="myDIV" class="col-lg-5">
			 	<div class="row">
			 		<div id="col_pl" class="col pl-0 pr-0 fill">
			 			<img src="/uploaded/img/articles/${articleEnchere.getPath_photo()}" alt="image article">
			 		</div>
			 		<div id="col"class="col" >
			 			<ul id="filter">
			 				<li id= "deco"><span id="research">${articleEnchere.getNom_article()}</span></li>
			 				<li><fmt:message key="txt.price"></fmt:message> : ${articleEnchere.getMontant_enchere()}</li>
			 				<li><fmt:message key="txt.end_of_auction"></fmt:message> :  ${articleEnchere.getDate_fin_encheres()}</li>
			 				<li id="num_cat" value="${articleEnchere.getNo_categorie()}"></li>
			 				<li><fmt:message key="txt.seller"></fmt:message> :  <a class="link" href="/ENI-Enchere/voirVendeur?pseudo=${articleEnchere.getPseudo()}">${articleEnchere.getPseudo()}</a></li>
						</ul>
			 		</div>
			 	</div>
			</div>
		</c:forEach>	
		</div>	
	</div>
<%@ include file="footer.jsp" %>	
</body>
<script>
$(document).ready(function(){
	$("#search").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		 $("#myDIV #research").filter(function() {		 
		      $(this).closest("#myDIV").toggle($(this).text().toLowerCase().indexOf(value) > -1);
		     // $(this).closest("#myDIV").hide($(this).text().toLowerCase().indexOf(value) > -1);
		 });
	});
	
    $("#selectCat").change(function(){
        var num_categorie = $(this).children("option:selected").val();
        $("#myDIV #num_cat").filter(function() {	
        	$(this).closest("#myDIV").toggle($(this).val() == num_categorie || num_categorie == "all");
        	//$(this).closest("#myDIV").hide($(this).val() == num_categorie || num_categorie == "all");
    	});
    });
});
</script>
</html>