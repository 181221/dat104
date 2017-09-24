<%@ page import="static no.hvl.dat104.controller.UrlMappings.RESETPASSORD_URL" %>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.LANDING_URL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 24.09.2017
  Time: 20.05
  To change this template use File | Settings | File Templates.
--%>
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
        <h1 style="text-align: center">Reset passord</h1>
        <div style="width: 30%; margin: 25px auto;">
            <form action="<%= RESETPASSORD_URL%>" method="POST">
                <div class="form-group">
                    <input class="form-control" type="text" name="email" placeholder="email">
                </div>
                <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block">Reset!</button>
                </div>
            </form>
            <a href=<%= LANDING_URL%>>Go Back</a>
        </div>
    </div>
</div>