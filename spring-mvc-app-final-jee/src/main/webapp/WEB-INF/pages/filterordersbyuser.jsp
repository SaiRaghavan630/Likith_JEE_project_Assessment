<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders by User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
 crossorigin="anonymous">
</head>
<body>
<form method="post" action="/orders/showordersbyuser">
     <div>
		 <label>User-Name</label>
		 <input type="text" name="orderedPerson" id="orderedPerson" class="form-control"/>
	</div>
	<div class="m-2 text-center">
		<input type="submit" value="Find">
	</div>
</form>

<table class="table table-info ">
    <thead>
        <tr>
            <th>S.NO</th>
            <th>Order-Id</th>
            <th>Ordered-Person</th>
            <th>Product-Id</th>
        </tr>
    </thead>
<tbody>
<c:forEach items="${list}" var="each">
<tr>
        <td>${each.serNo}</td>
        <td>${each.orderId}</td>
        <td>${each.userName}</td>
        <td>${each.productId}</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>