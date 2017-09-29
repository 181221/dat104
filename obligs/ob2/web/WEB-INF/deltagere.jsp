<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 29.09.2017
  Time: 15.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.pederyo.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="1">
    <thead>
        <tr bgcolor="#cccccc">
            <th>Kjønn</th>
            <th>Navn</th>
        </tr>
    </thead>
    <tbody>

    <%//TODO%>
    <c:forEach var ="bruker" items="${brukere}">
        <c:if test="${currentUser.mobil = bruker.mobil && bruker.harBetalt}">

        </c:if>
        <tr>
            <c:choose>
                <c:when test="${bruker.kjonn eq 'kvinne'}"><td>&#9792;</td></c:when>
                <c:otherwise><td>&#9794;</td></c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${currentUser.harBetalt == true}">
                    <td bgcolor="#7FFF00"><c:out value="${bruker.fornavn}"/> <c:out value="${bruker.etternavn}"/></td>
                </c:when>
                <c:otherwise><td bgcolor="#ffaaaa"><c:out value="${bruker.fornavn}"/> <c:out value="${bruker.etternavn}"/></td></c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href=<%=LOGGUT%>>Ferdig</a></p>
<jsp:include page="./partials/footer.jsp"/>
