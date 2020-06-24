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

<h4>${product.name}</h4>
<hr>

<div class="row py-5 px-5">
	<div class="col-12 col-sm-5">
		<img class="img-fluid" src="${product.src}"></img>
	</div>
	<div class="col-12 col-sm-7">
		<h5>
			<fmt:formatNumber value = "${product.price}" type = "currency"/>
		</h5>
		<h6>
			${product.description}
		</h6>
		
		<form action="/ASM3/cart" method="post">
			<input hidden="true" value="${product.id}" name="id" />
			<input hidden="true" value="add" name="action" />
			<button type="submit" class="btn badge-warning text-white">Add to cart</button>
		</form>
	</div>
</div>


<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>