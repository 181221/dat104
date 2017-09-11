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
    <title></title>
  </head>
  <body>
  <h1>Min Handleliste</h1>
  <form action="/vare" method="post">
    Legg Til: <input type="text" name="vare" placeholder="vare">
    <input type="submit" value="Submit">
  </form>
  </body>

  <c:forEach var="vare" items="${alleVarer}">
    <form action="/slett" method="post">
      <li><input type="hidden" name="varenavn" value="${vare.item}"><input type="submit" value="Slett">: ${vare.item}
    </form>
  </c:forEach>
  </form>
</html>
