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

<h2>Betalingsoversikt</h2>
<form action=<%=BETALINGSINFO%> method="post">
    <table border="1">
        <tr bgcolor="#cccccc"><th align="left">Navn</th><th>Mobil</th><th>Betalingsstatus</th></tr>
        <tr><td>Arne And</td><td>123 45 678</td><td align="center">Betaling mottatt</td></tr>
        <tr><td>Arne Arnesen</td><td>901 23 456</td><td><input type="submit" name="90123456" value="Registrer betaling" /></td></tr>
        <tr><td>Berit Beritsen</td><td>876 54 321</td><td><input type="submit" name="87654321" value="Registrer betaling" /></td></tr>
    </table>
</form>
<p><a href="kassererlogin.html">Ferdig</a></p>

<jsp:include page="./partials/footer.jsp"/>
