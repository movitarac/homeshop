package com.racic.homeshop;

public class Television extends Product {
    private int size;
    private String slabtype;

    public Television(String name, String description, double price, int size, String slabtype) {
        super(name, description, price);
        this.size = size;
        this.slabtype = slabtype;
    }

    public Television(String name, String description, double price) {
        super(name, description, price);
    }

    public int getSize() {
        return size;
    }

    public String getSlabtype() {
        return slabtype;
    }
}
