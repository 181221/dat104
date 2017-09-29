<%@ page import="static no.pederyo.controller.UrlMappings.DELTAGERLISTE" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 27.09.2017
  Time: 13.58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp;${ny.fornavn}<br/>
    &nbsp;&nbsp;&nbsp;${ny.etternavn}<br/>
    &nbsp;&nbsp;&nbsp;${ny.telefon}<br/>
    &nbsp;&nbsp;&nbsp;${ny.kjonn}</p>
<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href=<%= DELTAGERLISTE %>>Gå til deltagerlisten</a>
</body>
</html>
