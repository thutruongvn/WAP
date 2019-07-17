package com.shopping.controller;

import com.shopping.dao.UserAccess;
import com.shopping.model.User;
import com.shopping.utils.SessionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("username");
        SessionHelper.clearMessage(request);
        if(UserAccess.getUserByUsername(un) == null) {
            String ps = request.getParameter("password");
            User user = new User(un, ps);
            UserAccess.addUser(user);
            response.setStatus(HttpServletResponse.SC_OK);
//            response.getWriter().print("User " + un + " is created successfully.");
            request.getSession().setAttribute("success_msg_response", "User " + un + " is created successfully.");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().print("User " + un + " is existed.");
            request.getSession().setAttribute("err_msg_checkout", "User " + un + " is existed.");
        }
//        response.sendRedirect("/login");
//        response.getWriter().print("User " + un + " is created successfully.");
//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
//        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("/login");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }
}
