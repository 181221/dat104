<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 05.09.2017
  Time: 16.49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--spør etter lokal i parameter--%>
<%--<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
       scope="session"/>--%>

<c:set var="theLocal" value="${localen}" scope="session"/>
<fmt:setLocale value="${theLocal}" />
<fmt:setBundle basename="no.hvl.dat104.i18n.resources.mylabels" />


<html>
<head>
    <title>Lang</title>
</head>
<body>

<fmt:message key="label.greeting"/> ${navn.toUpperCase()} <br/> <br/>


<%--<a href="lang.jsp?theLocale=es_ES">Espanol (ES)</a>

<a href="lang.jsp?theLocale=no_NO">Norsk (NO)</a>

<a href="lang.jsp?theLocale=de_DE">German (DE)</a>
<div></div>--%>



</body>
</html>
