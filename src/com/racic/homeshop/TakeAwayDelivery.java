package com.racic.homeshop;

public class TakeAwayDelivery implements Delivery{
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getInfo() {
        return "retrait 0euro";
    }
}
