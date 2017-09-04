<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 04.09.2017
  Time: 13.25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Map<Integer, Integer> k;
    Map<Integer, String> j;
    k = (Map<Integer, Integer>) request.getSession().getAttribute("stemme");
    j = (Map<Integer, String>) request.getSession().getAttribute("partier");
%>

<html>
<head>
    <title>Resultatet</title>
</head>
<body>
<h1>Resultatet</h1>
<ul>
    <% for (int i = 0; i < k.size(); i++) {%>
    <% System.out.println(j.get(i) + k.get(i)); %>
    <li><%= j.get(i) %>&emsp;<%= k.get(i)%>
    </li>
    <%}%>
</ul>

<a href="index.jsp">Stem på nytt</a>
</body>
</html>
