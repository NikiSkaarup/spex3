<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2016-09-10
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Cupcake - Shop</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <div class="row">
        <div class="col-8">
            <form action="shop" method="post">
                <label for="toppings">Toppings</label>
                <select name="topping" id="toppings" title="toppings">
                    ${requestScope.toppings}
                </select>
                <label for="bottoms">Bottoms</label>
                <select name="bottom" id="bottoms" title="bottoms">
                    ${requestScope.bottoms}
                </select>
                <input name="amount" type="text" placeholder="amount" required/>
                <button name="submit" type="submit" value="shop">Add to cart</button>
            </form>
        </div>
        <div class="col-4">
            ${requestScope.sideCart}
        </div>
    </div>
</div>

<%@ include file="scripts.jsp" %>
</body>
</html>
