<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 29.09.2017
  Time: 18.11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.pederyo.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="formaterTlf" class="no.pederyo.utils.TelefonUtil"/>
<h2>Betalingsoversikt</h2>
<table border ="1">
    <thead>
        <tr>
            <th>Navn</th>
            <th>Mobil</th>
            <th>Betalingsstatus</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="bruker" items="${brukere}">
        <tr>
            <td><c:out value ="${bruker.fornavn}"/>  <c:out value ="${bruker.etternavn}"/></td>
            <td><c:out value="${formaterTlf.formaterTlf(bruker.telefon)}"/></td>
            <c:choose>
                <c:when test = "${bruker.harBetalt == true}"><td>Betaling motatt</td></c:when>
                <c:otherwise>
                    <td>
                        <form action=<%=BETALINGSINFO%> method="post">
                            <input type="hidden" name="mobil" value="${bruker.telefon}">
                            <input type="submit" value="Registrer betaling">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href=<%=LOGGUT%>>Ferdig</a></p>
<jsp:include page="./partials/footer.jsp"/>
