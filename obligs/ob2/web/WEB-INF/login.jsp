<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 29.09.2017
  Time: 17.04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.pederyo.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div class="row">

        <c:if test="${flash == 'Error'}">
            <p class="alert alert-danger"> ${melding}</p>
            <c:remove var="flash" scope="session" />
        </c:if>
        <c:if test="${flash == 'Success'}">
            <p class="alert alert-success"> ${melding}</p>
            <c:remove var="flash" scope="session" />
        </c:if>
    </div>
</div>
<h3>Logg inn</h3>
<p>Det er kun registrerte deltagere som får se deltagerlisten.
    Logg inn ved å gi mobil-nummeret ditt.</p>
<form action=<%=LOGIN%> method="POST">
    <fieldset>
        <p>Mobil: <input type="password" name="mobil" placeholder="90123456" /></p>
        <p><input type="submit" value="Logg inn" /></p>
    </fieldset>
</form>
<jsp:include page="./partials/footer.jsp"/>
