package com.example.ecommerceshopping.servlet;

import com.example.ecommerceshopping.connection.DbCon;
import com.example.ecommerceshopping.dao.OrderDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            if(id != null) {
                OrderDao orderDao = new OrderDao(DbCon.getConnection());
                orderDao.cancelOrder(Integer.parseInt(id));
            }
            response.sendRedirect("orders.jsp");
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }

}