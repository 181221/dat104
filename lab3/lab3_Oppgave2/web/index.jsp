<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 04.09.2017
  Time: 12.50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Valg 2017</title>
  </head>
  <body>
  <form action="result" method="post" style="margin: auto; width: 40%; margin-top: 10%;">
      <h3>Valg</h3>
      <div style="margin-top: 15px;">
          <input type="radio" name="radio1" value="0" checked> SV
          <input type="radio" name="radio1" value="1" >AP
          <input type="radio" name="radio1" value="2" >rodt
          <input type="radio" name="radio1" value="3" >venstre

      </div>
      <div style="margin-top: 15px;">
          <input type="submit"> Stem!
      </div>
  </form>
  </body>
</html>
