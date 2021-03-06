<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 24.09.2017
  Time: 19.32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
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
            <form action="<%= REGISTRER_URL%>" method="POST">
                <div class="form-group">
                    <input class="form-control" type="text" name="username" placeholder="username">
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="email">
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="password">
                </div>
                <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block">Register!</button>
                </div>
            </form>
            <a href=<%= LANDING_URL%>>Go Back</a>
        </div>
    </div>
</div>



<jsp:include page="./partials/footer.jsp" />
