<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />

<form action="/" method="POST">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" placeholder="Arne"/></p>
    <p>Etternavn: <input type="text" name="etternavn"  placeholder="Arnesen" /></p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" placeholder="90123456" /></p>
    <p>Kjønn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
      <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
<jsp:include page="./partials/footer.jsp" />