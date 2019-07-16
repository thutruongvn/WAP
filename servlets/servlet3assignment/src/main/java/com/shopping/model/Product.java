package com.shopping.model;

public class Product {

    private int id;
    private String name;
    private String price;
    private String img;

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Product(int id, String name, String price, String img) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Product(String name, String price) {
        super();
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
