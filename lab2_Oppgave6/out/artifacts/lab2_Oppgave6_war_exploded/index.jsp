<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 28.08.2017
  Time: 22.27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Temperaturomregning</title>
  </head>
  <body>

      <form action="beregn" method="get" style="margin: auto; width: 40%; margin-top: 10%;">
          <h3>Temperaturomregning</h3>
          <div>
              Temperatur <input type="text" name="temperatur">
          </div>
          <div style="margin-top: 15px;">
              <input type="radio" name="radio1" value="celsius" checked> Celsius til Fahrenheit
              <input type="radio" name="radio1" value="fahrenheit" >Fahrenheit til Celsius
          </div>
          <div style="margin-top: 15px;">
              <input type="submit"> Beregn!
          </div>
      </form>
  </body>
</html>
