<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${flash == 'Error'}">
  <p class="alert alert-danger"> ${melding}</p>
  <c:remove var="flash" scope="session" />
</c:if>
<c:if test="${flash == 'Success'}">
  <p class="alert alert-success"> ${melding}</p>
  <c:remove var="flash" scope="session" />
</c:if>

<form action="/" method="POST">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" placeholder="Arne"/></p>
    <p>Etternavn: <input type="text" name="etternavn"  placeholder="Arnesen" /></p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" placeholder="90123456" /></p>
    <p>Kj�nn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
      <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
    <p><input type="submit" value="Meld meg p�" /></p>
  </fieldset>
<jsp:include page="./partials/footer.jsp" />