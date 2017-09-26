<%@ page import="static pwa.controller.UrlMappings.HANDLELISTE_URL" %>
<%@ page import="static pwa.controller.UrlMappings.LOGIN_URL" %><%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 12.09.2017
  Time: 23.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <div class="row">
        <c:if test="${empty loggedInUser}">
            <p>Du er ikke logget inn!</p>
            <p>Logg inn <a href="<%= LOGIN_URL%>">her</a></p>
        </c:if>
        <c:if test="${not empty loggedInUser}">
            gå til handlelisten <a href="<%= HANDLELISTE_URL%>">handleliste</a>
        </c:if>
        ${melding}
    </div>
</div>
