package com.shopping.controller;

import com.google.gson.Gson;
import com.shopping.dao.ProductAccess;
import com.shopping.dao.ShoppingCartAccess;
import com.shopping.model.CartItem;
import com.shopping.model.Product;
import com.shopping.model.ShoppingCart;
import com.shopping.utils.SessionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        SessionHelper.clearMessage(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shoppingCart.jsp");
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(request);
        request.setAttribute("cartItems", shoppingCart.getItems());
        request.setAttribute("totalPrice", shoppingCart.getTotalPrice());
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(req);

        String ids = req.getParameter("ids");
        String action = req.getParameter("action");
        Map<String, String> mapProductIdQuantity = (Map<String, String>) new Gson().fromJson(req.getReader(), Object.class);

        List<Integer> productIds = Arrays.stream(ids.split(",")).filter(e -> !e.isEmpty()).map(Integer::new).collect(Collectors.toList());

        List<CartItem> cartItems = shoppingCart.getItems();

        if ("remove".equals(action)) {
            cartItems = cartItems.stream().filter(e -> !productIds.contains(e.getItem().getId())).collect(Collectors.toList());
            shoppingCart.setItems(cartItems);
        } else if ("update".equals(action)) {
            cartItems.stream().filter(e -> productIds.contains(e.getItem().getId())).forEach(e -> {
                Integer newQuantity = Integer.valueOf(mapProductIdQuantity.get(String.valueOf(e.getItem().getId())));
                e.setQuantity(newQuantity);
            });
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("shoppingCart", shoppingCart);
        shoppingCartDAO.setShoppingCart(req);

    }
}
