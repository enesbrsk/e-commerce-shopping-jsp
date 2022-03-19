package com.example.ecommerceshopping.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()){

            if (request.getSession().getAttribute("auth" ) != null){
                request.getSession().removeAttribute("auth");
                response.sendRedirect("login.jsp");
            }else {
                response.sendRedirect("index.jsp");
            }
        }
    }

}
