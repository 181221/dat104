<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 06.09.2017
  Time: 15.02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Person</title>
</head>
<body>
    <form action="person" method="post" style="border: 1px solid black; margin:10%;">
    <c:choose>
        <c:when test="${autofil}">
            Fornavn: <input type="text" name="fornavn" value=${fornavn}>
            <br />
            Etternavn: <input type="text" name="etternavn" value=${etternavn}>
        </c:when>
        <c:otherwise>
            Fornavn: <input type="text" name="fornavn" placeholder="fornavn" >
            <br />
            Etternavn: <input type="text" name="etternavn" placeholder="etternavn..">
        </c:otherwise>
    </c:choose>
        <br />
        <input type="Submit" value="Submit">

    </form>
</body>
</html>
