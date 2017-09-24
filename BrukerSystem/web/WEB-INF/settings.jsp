<%@ page import="static no.hvl.dat104.controller.UrlMappings.RESETPASSORD_URL" %>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.LANDING_URL" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 24.09.2017
  Time: 22.07
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
        <h1 style="text-align: center">Register</h1>
        <div style="width: 30%; margin: 25px auto;">
            <form action="<%= SETTINGS_URL%>" method="POST">
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="passord">
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password1" placeholder="password">
                </div>
                <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block">Register!</button>
                </div>
            </form>
            <a href=<%= LANDING_URL%>>Go Back</a>
        </div>
    </div>
</div>