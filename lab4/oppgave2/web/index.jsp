<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 06.09.2017
  Time: 19.08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Hei</title>
  </head>
  <body>
  <c:if test="${!riktigbruker}">
    <p style="color:red">Feil brukernavn!</p>
  </c:if>
  <form action="/login" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
