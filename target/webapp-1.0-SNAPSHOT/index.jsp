<%-- 
    Document   : index
    Created on : 23.11.2019, 22:15:55
    Author     : User
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Objects</title>
</head>
<body>
<h2>Objects List</h2>
<table>
<c:forEach var="product" items="${products}">
    
 <tr><td>${product.name}
 <a href ="<c:url value ="/edit?id=${product.id}"/>">Edit</a>
 <a href ="<c:url value ="/showAtt?id=${product.id}"/>">Show Atributes</a>
        <form method="post" action ="<c:url value ="/delete" />" style ="display:inline;">
            <input type="hidden" name="id" value ="${product.id}">
            <input type="submit" value="Delete">
        </form>
</td></tr>

</c:forEach>

 <p><a href="<c:url value ="/create" />">Create new</a></p>
</table>
</body>
</html>