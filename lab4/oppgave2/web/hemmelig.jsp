<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 11.09.2017
  Time: 16.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hemmelig</title>
</head>
<body>
<p>du er logget inn som: ${brukernavn}</p>
<h1>Den hemmelige siden!!</h1>
<form action="/logout" method="post">
    <input type="submit" name="logut" value="Logout">
</form>
</body>
</html>
