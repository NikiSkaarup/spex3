<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2016-09-11
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Cupcake - Cart</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <div class="row">
        <div class="col-8">
            Welcome to the cupcake webshop, where you can order cupcakes for pickup
        </div>
        <div class="col-4">
            ${requestScope.sideCart}
        </div>
    </div>
</div>

<%@ include file="scripts.jsp" %>
</body>
</html>
