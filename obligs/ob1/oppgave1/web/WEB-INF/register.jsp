<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 13.09.2017
  Time: 01.56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./partials/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row">
        <h1 style="text-align: center">Register</h1>
        <div style="width: 30%; margin: 25px auto;">
            <form action="/register" method="POST">
                <div class="form-group">
                    <input class="form-control" type="text" name="username" placeholder="username">
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="password">
                </div>
                <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block">Register!</button>
                </div>
            </form>
            <a href="/">Go Back</a>
        </div>
    </div>
</div>



<jsp:include page="./partials/footer.jsp" />