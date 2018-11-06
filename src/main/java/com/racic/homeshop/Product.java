package com.racic.homeshop;

public class Product {
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Display a full desc of a product
     */
    public void look(){

    }

    /**
     * add the product to a bill
     * @param bill (the concerned bill)
     * @param quantity the quantity of products to add
     */
    public void buy(Bill bill, Integer quantity) {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
