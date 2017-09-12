<%--
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
            <p>Logg inn her <a href="/login">her</a></p>
        </c:if>
        <c:if test="${not empty loggedInUser}">
            gå til handlelisten <a href="/handleliste">handleliste</a>
        </c:if>
    </div>
</div>
