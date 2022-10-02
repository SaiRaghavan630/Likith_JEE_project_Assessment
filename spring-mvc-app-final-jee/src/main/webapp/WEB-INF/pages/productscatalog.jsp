<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Catalog</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
 crossorigin="anonymous">

</head>
<body>
<center>
<h1>All details of Customers</h1></center>
<table class="table table-info">
    <thead>
        <tr>
            <th>product-id</th>
            <th>merchant-name</th>
            <th>product-name</th>
            <th>product-price</th>
            <th>product-inventory</th>
        </tr>
    </thead>
<tbody>
<c:forEach items="${list}" var="each">
<tr>
        <td>${each.productId}</td>
        <td>${each.merchant}</td>
        <td>${each.productName}</td>
        <td>${each.productPrice}</td>
        <td>${each.inventory}</td>
</tr>
</c:forEach>
    
</tbody>
</table>

</body>
</html>