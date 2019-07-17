package com.shopping.controller;

import com.shopping.dao.UserAccess;
import com.shopping.model.User;
import com.shopping.utils.SessionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/login"})
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("txtUsername");
        String ps = request.getParameter("txtPassword");
        User user = new User(un, ps);
        if(UserAccess.validateAccount(user)) {
            Boolean remember = request.getParameterValues("chkRemember") != null;
            String cUsername = remember ? un : "";
            int cTimeout = remember ? 30*24*60*60 : 0;
            Cookie loginCookie = new Cookie("username", cUsername);
            loginCookie.setMaxAge(cTimeout);
            response.addCookie(loginCookie);
            HttpSession session = request.getSession();
            session.setAttribute("user_info", user.getUsername());
            request.getSession().setAttribute("err_msg_checkout", null);
            response.sendRedirect("/");
        } else {
            request.getSession().setAttribute("err_msg_checkout", "Username or password is not correct. Please try again.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        SessionHelper.clearMessage(request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
    }
}
