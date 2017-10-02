<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 29.09.2017
  Time: 17.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.pederyo.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${flash == 'Error'}">
    <p style="color:red;">${melding}</p>
    <c:remove var="flash" scope="session" />
</c:if>
<h2>Kasserer login</h2>
<form action=<%=LOGGINNKASSERER%> method="post">
    <fieldset>
        <legend>Kasserer login</legend>
        <p>Passord: <input type="password" name="passord" placeholder="allstars" /></p>
        <p><input type="submit" value="Logg inn" /></p>
    </fieldset>
</form>
<a href=<%=PAAMELDING_URL%>>Meld det på her!</a> &emsp; <a href=<%=LOGIN%>>Login Som Deltager</a>
<jsp:include page="./partials/footer.jsp"/>
