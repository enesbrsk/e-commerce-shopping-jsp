<%@ page import="com.example.ecommerceshopping.model.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null){
        request.setAttribute("auth",auth);
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <%@include file="includes/head.jsp"%>
    <title>Shopping Cart Login</title>

</head>
<body>
<%@include file="includes/navbar.jsp"%>

<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Login</div>
        <div class="card-body">
            <form action="user-login" method="post">
                <div class="form-group">
                    <label>Email Adress</label>
                    <input class="form-control" name="login-email" type="email" placeholder="Enter Your Email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input class="form-control" name="login-password" type="password" placeholder="******" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>

</div>


<%@include file="includes/footer.jsp"%>
</body>
</html>