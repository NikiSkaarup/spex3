<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2016-09-11
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%--
--%><!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Cupcake - Login</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <div class="row">
        <div class="col-6">
            <form action="login" method="post">
                <input name="username" type="text" placeholder="username" autofocus required/>
                <input name="password" type="password" placeholder="password" required/>
                <button name="submit" type="submit" value="login">Login</button>
            </form>
        </div>
        <div class="col-6">
            <p>Login to order cupcakes for pickup!</p>
        </div>
    </div>
</div>

<%@ include file="scripts.jsp" %>
</body>
</html>