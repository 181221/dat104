<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 28.08.2017
  Time: 12.18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Valuta</title>
  </head>
  <body>
    <form action="resultat">
      <div>
        beløp<input type="text" name="fra-belop">
        <select name="currency-fra">
          <option value="NOK">NOK</option>
          <option value="USD">USD</option>
          <option value="SEK">SEK</option>
          <option value="EURO">EURO</option>
        </select>
      </div>
      <div>
        Skal veksles til
        <select name="currency-til">
          <option value="NOK">NOK</option>
          <option value="USD">USD</option>
          <option value="SEK">SEK</option>
          <option value="EURO">EURO</option>
        </select>
      </div>
      <input type="Submit" value="Submit">
    </form>
  </body>
</html>
