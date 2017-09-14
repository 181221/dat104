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
            <p class="alert alert-danger"> ${melding}</p>
            <c:remove var="flash" scope="session" />
        </c:if>
        <c:if test="${flash == 'Success'}">
            <p class="alert alert-success"> ${melding}</p>
            <c:remove var="flash" scope="session" />
        </c:if>
        <form class="form-group" action="/handleliste" method="post">
            <label for="LeggTil">Legg Til:</label>
             <input type="text" class="form-control" id="LeggTil" name="vare" placeholder="Varenavn..">
            <input style="margin: 10px;" class="btn btn-primary" type="submit" value="Submit">
        </form>

        <c:forEach var="vare" items="${varer}">
            <form action="/handleliste" method="post">
                <li style="list-style-type: none;"><input type="hidden" name="varenavn" value="${vare.vare_id}"><input class="btn btn-danger" type="submit" value="Slett"> ${vare.navn}
            </form>
        </c:forEach>
    </div>
</div>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
