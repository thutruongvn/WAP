package com.shopping.dao;

import com.shopping.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAccess {

    static Map<Integer, Product> productsDb = new HashMap<>();

    {
        productsDb.put(1, new Product(1, "Little blue", "25", "blue-flowers.jpg"));
        productsDb.put(2, new Product(2, "Cone", "10", "cone.jpg"));
        productsDb.put(3, new Product(3, "Corn", "5", "corn.jpg"));
        productsDb.put(4, new Product(4, "Green vegetable", "5", "green.jpg"));
        productsDb.put(5, new Product(5, "Hydrangea", "15", "hydrangea.jpg"));
        productsDb.put(6, new Product(6, "Pegplant", "5", "pegplant.jpg"));
        productsDb.put(7, new Product(7, "Snowflake", "15", "snowflake.jpg"));
        productsDb.put(8, new Product(8, "Sunflower", "15", "sunflower.jpg"));
        productsDb.put(9, new Product(9, "Daisy", "15", "daisy.jpg"));
    }

    public static void addProduct(Product product){
        productsDb.put(product.getId(), product);
    }

    public static void deleteProduct(int productId){
        productsDb.remove(productId);
    }

    public static void updateProduct(Product product){
        productsDb.put(product.getId(), product);
    }

    public static List<Product> getAllProducts(){
        return new ArrayList<>(productsDb.values());
    }

    public static Product getProductById(int productId){
        return productsDb.get(productId);
    }

    public static int genId() {
        return productsDb.size()+1;
    }
}