<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 06.09.2017
  Time: 19.47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Resultater</title>
</head>
<body>
<c:forEach var="bruker" items="${alleBrukere}">
    <li>${bruker.navn}</li>
</c:forEach>

</body>
</html>
