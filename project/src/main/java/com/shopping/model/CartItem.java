package com.shopping.model;

public class CartItem {
    private Product item;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product item, double price, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public double getPrice() {
        return Double.parseDouble(this.item.getPrice())  * this.quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}