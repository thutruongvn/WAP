package com.shopping.filter;

import com.shopping.model.ShoppingCart;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ShoppingCartFilter ",urlPatterns = {"*"})
public class ShoppingCartFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;

        HttpSession httpSession =httpServletRequest.getSession();
        ShoppingCart shoppingCart = (ShoppingCart)httpSession.getAttribute("shoppingCart");
        if(shoppingCart != null){
            req.setAttribute("numItems", shoppingCart.getNumberOfItems());
        }else
            req.setAttribute("numItems", 0);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
