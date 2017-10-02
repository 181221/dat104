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
    <c:forEach var ="bruker" items="${brukere}">
        <tr bgcolor="${currentUser.telefon eq bruker.telefon ? (bruker.harBetalt ? '#aaffaa' : '#ffaaaa'): ''}">
            <td align="center">${bruker.kjonn eq 'mann' ? '&#9794;' : '&#9792;'}</td>
            <td><c:out value="${bruker.fornavn} ${bruker.etternavn}" /></td>
       </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href=<%=LOGGUT%>>Ferdig</a></p>
<jsp:include page="./partials/footer.jsp"/>




