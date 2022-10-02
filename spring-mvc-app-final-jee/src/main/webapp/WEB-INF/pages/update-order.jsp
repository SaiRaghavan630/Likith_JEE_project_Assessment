<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Order</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
 crossorigin="anonymous">
</head>
<body>
<h2>Update Order</h2>
<form:form modelAttribute="command" method="post" action="/orders/update-order">
		
		<div>
		    <label>Order Ser.No</label>
			<form:input path="serNo" id="serNo" class="form-control" type="number"/>
		</div>
				
		<div>
		    <label>Order-ID</label>
			<form:input path="orderId" id="orderId" class="form-control" type="number"/>
		</div>
		<div>
		    <label>Customer-Name</label>
			<form:input path="userName" id="userName" class="form-control"/>
		</div>
		<div>
		    <label>Product ID</label>
		    <form:select path="productId" class="form-control" >
		          <form:option value="0" label="select product id"/>
		          <c:forEach items="${list}" var="each">
		          <form:option value="${each.productId}" label="${each.productId}" />  
		          </c:forEach>
		    </form:select>
		</div>
	<div>
			<input type="submit" value="update">
		</div>
</form:form>
<p style="color: #00FF00">${message}</p>
</body>
</html>