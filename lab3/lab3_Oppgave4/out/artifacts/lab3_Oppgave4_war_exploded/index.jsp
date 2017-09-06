<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 06.09.2017
  Time: 13.41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Personlige Opplysninger</title>
  </head>
  <body>
    <form action="person" method="post" style="border: 1px solid black; margin:10%;">
      <div>
        Fornavn: <input type="text" name="fornavn" placeholder="navn.." >
      </div>
      <div>
        Etternavn: <input type="text" name="etternavn" placeholder="etternavn..">
      </div>
      <input type="Submit" value="Submit">
    </form>
  </body>
</html>
