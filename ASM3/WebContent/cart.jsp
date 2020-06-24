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

<div class="py-5 px-5">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Products in cart: ${sessionScope.cart.count()}</th>
		      	<th scope="col">Price</th> 
		      	<th scope="col">Quantity</th>
		      	<th scope="col">Amount</th>
		      	<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${sessionScope.cart.getItems()}">
				<tr>
			      <th scope="row"><a href="/ASM3/product?id=${product.id}">ID: ${product.id}<br/>${product.name}</a></th>
			      <td><fmt:formatNumber value="${product.price}" type="currency"/></td>
			      <td>${product.number}</td>
				  <td><fmt:formatNumber value ="${product.price * product.number}" type="currency"/></td>
				  <td>
				  	<form action="/ASM3/cart" method="post">
				  		<input hidden="true" value="${product.id}" name="id" />
				  		<input hidden="true" value="remove" name="action" />
				  		<button class="btn btn-danger">remove</button>
				  	</form>
				  </td>
			    </tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<td></td>
				<td></td>
				<td></td>
				<td>Total: <fmt:formatNumber value="${sessionScope.cart.getAmount()}" type="currency"/></td>
			</tr>
		</tfoot>
	</table>
	
	<form action="/ASM3/cart" method="post">
		<input hidden="true" value="checkout" name="action" />
		<div class="form-group">
			<label>Customer email</label>
			<input required="required" type="email" class="form-control" placeholder="customer email" name="email" />
		</div>
		<div class="form-group">
			<label>Customer address</label>
			<input required="required" type="text" class="form-control" placeholder="customer address" name="address" />
		</div>
		<div class="form-group">
			<label>Discount code if any</label>
			<input required="required" type="text" class="form-control" size="8" placeholder="discount code" name="discount" />
		</div>
		<button type="submit" class="btn badge-warning text-white">Submit</button>
	</form>
</div>

<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>