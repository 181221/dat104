<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 05.09.2017
  Time: 11.41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%--<%
    String[] byer = {"bergen","oslo","Stavanger"};
    pageContext.setAttribute("byer",byer);
%>--%>
<html>
<head>
    <title>Stem her</title>
</head>
<body>
<p>Her kan du stemme</p>

<form action="stem" method="post">
    <c:forEach var="parti" items="${options}" varStatus="i">
        <input type="radio" name="radio1" value="${i.index}" checked> ${parti}
    </c:forEach>
    <div>
        <input type="submit" value="Stem">
    </div>

</form>




</body>
</html>
