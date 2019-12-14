<%-- 
    Document   : edit
    Created on : 10.12.2019, 14:08:13
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Atribute</title>
</head>
<body>
<h3>Edit Atributet</h3>
<form method="post">
<input type="hidden" value="${atribute.id}" name="id" />
<input type="hidden" value="${atribute.el}" name="el" />
<label>Name</label><br>
<input name="name" value="${atribute.name}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>