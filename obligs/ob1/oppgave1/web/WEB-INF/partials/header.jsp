<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 12.09.2017
  Time: 15.56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Handleliste!</title>
    <meta charset="utf-8">
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
            <a class="navbar-brand" href="/#">Handleliste!</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">

                <%--<% if(!currentUser){ %>--%>
                <li><a href="/login">Login</a></li>
                <li><a href="/register">Sign Up</a></li>
                <%--<% } else { %>--%>
                <li>
                    <%--<a href= "/<%= currentUser.username %>"> Signed In As <%= currentUser.username %> <span class="glyphicon glyphicon-user" aria-hidden="true"></span>  </a>--%>
                </li>
                <%--<li><a href="/<%= currentUser.username %>/settings">Settings <i class="setting icon"></i> </a></li>--%>
                <li><a href="/logout">Logout</a></li>
                <%--<% } %>--%>
            </ul>
        </div>
    </div>
</nav>

