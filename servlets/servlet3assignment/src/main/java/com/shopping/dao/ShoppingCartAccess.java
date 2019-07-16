package com.shopping.dao;

import com.shopping.model.CartItem;
import com.shopping.model.Product;
import com.shopping.model.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShoppingCartAccess {
    public void setShoppingCart(HttpServletRequest req){
        HttpSession session = req.getSession(true);
        ShoppingCart sc = this.getShoppingCart(req);
        session.setAttribute("shoppingCart", sc != null ? sc : new ShoppingCart());
    }
    public ShoppingCart getShoppingCart(HttpServletRequest req){
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("shoppingCart") != null)
            return (ShoppingCart) session.getAttribute("shoppingCart");
        return null;
    }
    public void addToCart(Product item, int qty, ShoppingCart shoppingCart) {
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
