<%@ page import="com.example.ecommerceshopping.connection.DbCon" %>
<%@ page import="com.example.ecommerceshopping.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null){
        request.setAttribute("auth",auth);

    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="includes/head.jsp"%>

    <title>Orders Page</title>
</head>
<body>
<%@include file="includes/navbar.jsp"%>


<%@include file="includes/footer.jsp"%>
</body>
</html>