<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 24.09.2017
  Time: 16.49
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp" />
<div class="container">
  <div class="row">
    <c:if test="${empty currentUser}">
      <p>Du er ikke logget inn!</p>
      <p>Logg inn <a href="<%= LOGIN_URL%>">her</a></p>
    </c:if>
    <c:if test="${not empty currentUser}">
      Du er logget inn
    </c:if>
  </div>
</div>
