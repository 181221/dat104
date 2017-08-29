<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 28.08.2017
  Time: 13.27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>resultat</title>
</head>
<body>
    <%
        if((boolean)request.getAttribute("gyldig")) {
    %>      <p>${fra} ${fraCur} blir: ${resultat} ${til}  </p><%
        }else {
    %> <p>du skrev inn feil </p> <%
        }
    %>

</body>
</html>
