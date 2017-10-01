<%@ page import="static no.pederyo.controller.UrlMappings.PAAMELDING_URL" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${flash == 'Error'}">
  <p style="color:red;">${melding}</p>
  <c:remove var="flash" scope="session" />
</c:if>
<form action=<%=PAAMELDING_URL%> method="post">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" placeholder="Arne"/></p>
    <p>Etternavn: <input type="text" name="etternavn"  placeholder="Arnesen" /></p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" placeholder="90123456" /></p>
    <p>Kjønn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
      <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
</form>
<jsp:include page="./partials/footer.jsp" />