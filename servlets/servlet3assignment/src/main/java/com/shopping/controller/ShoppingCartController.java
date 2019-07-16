package com.shopping.controller;

import com.shopping.dao.ProductAccess;
import com.shopping.dao.ShoppingCartAccess;
import com.shopping.model.Product;
import com.shopping.model.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/shopping-cart"})
public class ShoppingCartController extends HttpServlet {
    ShoppingCartAccess shoppingCartDAO = new ShoppingCartAccess();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shoppingCartDAO.setShoppingCart(req);
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer qty = Integer.parseInt(request.getParameter("qty"));
        Integer productId = Integer.parseInt(request.getParameter("productId"));

        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(request);
        if(shoppingCart != null) {
            Product item = ProductAccess.getProductById(productId);
            shoppingCartDAO.addToCart(item, qty, shoppingCart);
            HttpSession session = request.getSession(true);
            session.setAttribute("shoppingCart", shoppingCart);
            response.getWriter().write(String.valueOf(shoppingCart.getNumberOfItems()));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shoppingCart.jsp");
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(request);
        request.setAttribute("cartItems", shoppingCart.getItems());
        request.setAttribute("totalPrice", shoppingCart.getTotalPrice());
        requestDispatcher.forward(request, response);
    }


}
