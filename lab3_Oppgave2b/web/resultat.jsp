<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 04.09.2017
  Time: 13.25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultatet</title>
</head>
<body>
<h1>Resultatet</h1>
<table>
    <thead>
        <tr>
        <c:forEach items="${partier}" var="item">
            <th><c:out value="${item.value}"></c:out></th>
        </c:forEach>
        </tr>
    </thead>
    <tbody>
        <tr>
            <c:forEach items="${stemme}" var="item" varStatus="i">
            <td>${item.value}</td>
            </c:forEach>
        </tr>
    </tbody>
</table>

<a href="stem.jsp">Stem på nytt</a>
</body>
</html>
