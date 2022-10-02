<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index-page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
 crossorigin="anonymous">
<c:url value="/images/index-bg.jpg" var="background"/>
<style>
body{
background-image:url("/images/index-bg.jpg")
}
</style>
</head>
<body>
<h1 style="text-align: center">Electronic-Commerce store</h1>
      <ul>
         <li><a href="products">Products</a></li>
         <li><a href="orders">Orders</a></li>
     </ul>
</body>
</html>