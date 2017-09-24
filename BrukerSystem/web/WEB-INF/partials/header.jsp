<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 24.09.2017
  Time: 17.24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Handleliste!</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../public/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%= LANDING_URL%>">BrukerSystem!</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty currentUser}">
                    <li><a href="<%= LOGIN_URL%>">Login</a></li>
                    <li><a href="<%= REGISTER_URL%>">Sign Up</a></li>
                </c:if>
                <c:if test="${not empty currentUser}">
                    <li>
                        <a href= "<%= LANDING_URL%>"> Signed In As ${currentUser.brukernavn} <span class="glyphicon glyphicon-user" aria-hidden="true"></span> </a>
                    </li>

                    <li><a href="<%= LOGOUT_URL%>">Logout</a></li>

                </c:if>

            </ul>
        </div>
    </div>
</nav>