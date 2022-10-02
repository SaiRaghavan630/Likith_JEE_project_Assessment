<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update-Product</title>
</head>
<body>
<h2 >Update-Product</h2>
<form:form modelAttribute="command" method="post" action="/products/update-product">
		<div>
		    <label>Product-ID</label>
			<form:input path="productId" id="productId"  class="form-control" required="required"/>
		</div>		
		<div>
		    <label>Merchant-Name</label>
			<form:input path="merchant" id="merchant" class="form-control" required="required"/>
		</div>
		
		<div>
		    <label>Product-Name</label>
			<form:input path="productName" id="productName" class="form-control" required="required"/>
		</div>
		<div>
		    <label>Product-Price</label>
			<form:input path="productPrice" id="productPrice" class="form-control" required="required"/>
		</div>
		<div>
		    <label>Product-Inventory</label>
			<form:input path="inventory" id="inventory" class="form-control" required="required"/>
		</div>
		<div>
			<input type="submit" value="update">
		</div>
</form:form>
<p style="color: #00FF00">${message}</p>
</body>
</html>