package com.shopping.controller;

import com.google.gson.Gson;
import com.shopping.dao.ShoppingCartAccess;
import com.shopping.dao.UserAccess;
import com.shopping.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Gson mapper = new Gson();
    private ShoppingCartAccess shoppingCartDao = new ShoppingCartAccess();
    private UserAccess userDAO;
    private ShoppingCart shoppingCart;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shoppingCartDao.setShoppingCart(req);
        shoppingCart = shoppingCartDao.getShoppingCart(req);
        userDAO = (UserAccess)getServletContext().getAttribute("userDAO");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("user_info") == null) {
            req.getSession().setAttribute("err_msg_checkout", "Please sign in to checkout your order.");

            resp.sendRedirect("/login");
        }
        else
        {
            User user = userDAO.getUserByUsername((String) req.getSession().getAttribute("user_info"));
            req.setAttribute("user", user);
            req.getRequestDispatcher("checkout.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("order") != null){
            Order order = mapper.fromJson(req.getParameter("order"), Order.class);
            User user = userDAO.getUserByUsername(req.getSession().getAttribute("user_info").toString());
            order.setUsername(user.getUsername());
            List<OrderItem> orderItems = new ArrayList<>();
            for(CartItem cart: shoppingCart.getItems()){
                OrderItem orderItem = new OrderItem(UUID.randomUUID().toString(), cart.getQuantity(), cart.getItem());
                orderItems.add(orderItem);
            }
            order.setOrderItems(orderItems);

            req.getSession().setAttribute("shoppingCart", null);
            req.setAttribute("numItems", 0);
            shoppingCart = null;
            resp.getWriter().print("Checkout success for " + user.getUsername() + " with the total order amount $" + order.getTotal()
                                    + "\n We will deliver your package as soon as possible. Thank you.");
        } else {
            resp.getWriter().print("Error: something went wrong." );
        }
//        req.getSession().setAttribute("shoppingCart", null);
//        req.setAttribute("numItems", 0);
//        shoppingCart = null;
//        req.getSession().setAttribute("success_msg_response", "Checkout order successfully. Thank you!");

    }
}
