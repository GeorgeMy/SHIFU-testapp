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
<title>Atributes</title>
</head>
<body>
<h2>Atributes</h2>
<table>
    

<c:forEach var="atribute" items="${atributes}" >
    
 <tr><td>
 ${atribute.name}
  <a href ="<c:url value ="/editatribute?id=${atribute.id}&el=${atribute.el}"/>">Edit</a>
 <form method="post" action ="<c:url value ="/deleteAtribute" />" style ="display:inline;">
            <input type="hidden" name="name" value ="${atribute.name}">
            <input type="submit" value="Delete">
        </form>
</td></tr>

</c:forEach>
<p><a href="<c:url  value ="/addAtribute?el=${id}" />">Add atribute</a></p>
</table>
</body>
</html>