package com.shopping.controller;

import com.google.gson.Gson;
import com.shopping.dao.ProductAccess;
import com.shopping.model.CartItem;
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
import java.util.List;

//@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"shopping-cart"})
@WebServlet({"/shopping-cart"})
public class ShoppingCartServlet extends HttpServlet {

    Gson mapper = new Gson();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ShoppingCart sc = getShoppingCart(req);
        session.setAttribute("shoppingCart", sc != null ? sc : new ShoppingCart());
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer qty = Integer.parseInt(request.getParameter("qty"));
        Integer productId = Integer.parseInt(request.getParameter("productId"));

//        String jsonString = request.getParameter("product");
//        Product product = mapper.fromJson(jsonString, Product.class);
        ShoppingCart shoppingCart = getShoppingCart(request);
        if(shoppingCart != null) {
            Product item = ProductAccess.getProductById(productId);
            addToCart(item, qty, shoppingCart);
            HttpSession session = request.getSession(true);
            session.setAttribute("shoppingCart", shoppingCart);
            response.getWriter().write(String.valueOf(shoppingCart.getNumberOfItems()));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shoppingCart.jsp");
        ShoppingCart shoppingCart = getShoppingCart(request);
        request.setAttribute("cartItems", shoppingCart.getItems());
        request.setAttribute("totalPrice", shoppingCart.getTotalPrice());
        requestDispatcher.forward(request, response);
    }
    private ShoppingCart getShoppingCart(HttpServletRequest req){
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("shoppingCart") != null)
            return (ShoppingCart) session.getAttribute("shoppingCart");
        return null;
    }
    private void addToCart(Product item, int qty, ShoppingCart shoppingCart) {
//        Product item = ProductAccess.getProductById(id);
        List<CartItem> cartItems = shoppingCart.getItems();
        boolean addDuplicatedItem = false;

        for(CartItem e: cartItems){
            if(e.getItem() == item) {
                e.setQuantity(e.getQuantity() + qty);
                addDuplicatedItem = true;
            }
        }
        if(!addDuplicatedItem)
            shoppingCart.getItems().add(new CartItem(item, Double.parseDouble(item.getPrice()), qty));
    }

}
