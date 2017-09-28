<%@ page import="static no.pederyo.controller.UrlMappings.*" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 28.09.2017
  Time: 18.01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<%=PAAMELDING_URL%>" method="POST">
    <fieldset>
        <legend>Personlige data</legend>
        <p>Fornavn: <input type="text" name="fornavn" value="${cookie.get(0)}"/></p>
        <p>Etternavn: <input type="text" name="etternavn"  value="${cookie.get(1)}" /></p>
        <p>Mobil (8 siffer): <input type="text" name="mobil" value="${cookie.get(2)}" /></p>
        <p>Kjønn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
            <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
        <p><input type="submit" value="Meld meg på" /></p>
    </fieldset>
<jsp:include page="./partials/footer.jsp" />
