<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US"/>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link type="text/css" rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>PRJ321 - ASM3</title>
</head>
<body class="container">

<%@ include file="header.jsp" %>

<div class="row">
	<c:if test="${products == null || products.size() == 0}"><p class="col-12 text-danger">Not found</p></c:if>
	<c:forEach var="product" items="${products}">
		<div class="col-12 col-sm-6 col-md-4 py-4 px-4">
			<div class="border border-secondary rounded">
				<div class="d-flex flex-column justify-content-center align-items-center py-4 px-4">
					<a href="/ASM3/product?id=${product.id}">
						<img class="img-fluid" src="${product.src}"></img>
					</a>
					<h5 class="my-2">${product.type}</h5>
					<h6 class="my-2">${product.name}</h6>
					<p>
	         			<fmt:formatNumber value = "${product.price}" type = "currency"/>
         			</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>