<%@ page import="model.User" %>
<div class="row">
    <div id="nav" class="col-9">
        <ul id="menu">
            <li><a class="btn" href="${pageContext.request.contextPath}/">Home</a></li>
            <%
                if (request.getSession().getAttribute("user") != null) {
                    out.print("<li><a class='btn' href='shop'>Shop</a></li>");
                    out.print("<li><a class='btn' href='cart'>Cart</a></li>");
                    out.print("<li><a class='btn' href='profile'>User Profile</a></li>");
                }
                else {
                    out.print("<li><a class='btn' href='login'>Login</a></li>");
                }
            %>
        </ul>
    </div>
    <%
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            out.print("<div id='userInfo' class='col-3' data-user-id='"+ user.getId() +"'>");
            out.print("<p>" + user.getUsername() + "</p>");
            out.print("<p>Balance: " + user.getBalance() + "</p>");
            out.print("</div>");
        }
    %>
</div>
