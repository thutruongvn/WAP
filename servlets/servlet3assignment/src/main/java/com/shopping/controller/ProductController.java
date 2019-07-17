package com.shopping.controller;

import com.google.gson.Gson;
import com.shopping.dao.ProductAccess;
import com.shopping.model.Product;
import com.shopping.utils.SessionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/product", ""})
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductAccess dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new ProductAccess();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SessionHelper.clearMessage(request);
        request.setAttribute("products", dao.getAllProducts());
        RequestDispatcher view = request.getRequestDispatcher("product.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsonString = request.getParameter("product");
        Product product = mapper.fromJson(jsonString, Product.class);
        product.setId(dao.genId());
        dao.addProduct(product);

        PrintWriter out = response.getWriter();

        out.print(mapper.toJson(product));
    }
}