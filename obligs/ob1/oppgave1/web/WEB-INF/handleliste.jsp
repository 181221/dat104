<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 12.09.2017
  Time: 22.56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="./partials/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <div class="row">
<c:if test="${flash == 'Error'}">
    <p class="alert alert-danger">${param.message}</p>
    <c:remove var="flash" scope="session" />
</c:if>
<c:if test="${flash == 'Success'}">
    <p class="alert alert-success">${param.message}</p>
    <c:remove var="flash" scope="session" />
</c:if>

<p>her kommer handlelisten</p>
    </div>
</div>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
