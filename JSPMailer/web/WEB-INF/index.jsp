<%@ page import="static no.hvl.dat104.controller.UrlMappings.LANDING_URL" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 23.09.2017
  Time: 13.46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP mailer</title>
  </head>
  <body>
    <p>JSP mailer</p>
    <form action="<%=LANDING_URL%>" method="POST">
      Til: <input type="text" placeholder="abc@gmail.com" name="til">
      <p>Subject: <input type="text" placeholder="Mail..." name="subject"></p>

      <p>Message: <input type="text" placeholder="Skriv en melding..." name="msg"></p>
      <p><input type="submit" value="Send Mail"></p>
    </form>
  </body>
</html>
