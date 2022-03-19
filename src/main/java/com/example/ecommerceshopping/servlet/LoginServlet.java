package com.example.ecommerceshopping.servlet;

import com.example.ecommerceshopping.connection.DbCon;
import com.example.ecommerceshopping.dao.UserDao;
import com.example.ecommerceshopping.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {

      private static final long serialVeersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {

            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");

            UserDao userDao = new UserDao(DbCon.getConnection());
            User user = userDao.userLogin(email,password);

            if (user != null){
                request.getSession().setAttribute("auth",user);
                response.sendRedirect("index.jsp");
            }else {
                System.out.println("user login fail");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
