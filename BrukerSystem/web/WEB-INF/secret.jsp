<%@ page import="no.hvl.dat104.controller.UrlMappings" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 24.09.2017
  Time: 19.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./partials/header.jsp" />
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
        <a href="<%= UrlMappings.RESETPASSORD_URL%>">Reset passord</a>
    </div>
</div>
