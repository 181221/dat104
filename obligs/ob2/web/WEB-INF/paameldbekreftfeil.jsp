<%@ page import="static no.pederyo.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${flash == 'Error'}">
    <p style="color:red;">${melding}</p>
    <c:remove var="flash" scope="session" />
</c:if>
<form action="<%=PAAMELDING_URL%>" method="POST">
    <fieldset>
        <legend>Personlige data</legend>
        <span bgcolor="#FF0000"></span>
        <p>Fornavn: <input type="text" name="fornavn" value="${fornavn}"/><span style="color: red;">${feilfornavn}</span></p>
        <p>Etternavn: <input type="text" name="etternavn"  value="${etternavn}"/><span style="color: red;">${feiletternavn}</span></p>
        <p>Mobil (8 siffer): <input type="text" name="mobil" value="${mobil}"/><span style="color: red;">${feilmobil}</span></p>
        <p>Kjønn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
            <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
        <p><input type="submit" value="Meld meg på" /></p>
    </fieldset>
<jsp:include page="./partials/footer.jsp" />
