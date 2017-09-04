<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 03.09.2017
  Time: 20.19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  StringEscapeUtils sc = new StringEscapeUtils();
%>
<html>
  <head>
    <title>hacking</title>
  </head>
  <body>
  <h1>hei</h1>
    <form action="servlet" method="get">
      Ditt navn: <input type="text" placeholder="navn" name="navn">
      <input type="submit" value="Hallo">
    </form>


    ${param.navn}


  </body>
</html>
