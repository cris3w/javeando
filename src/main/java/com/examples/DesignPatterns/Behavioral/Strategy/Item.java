package com.examples.DesignPatterns.Behavioral.Strategy;

public class Item {

    private String code;
    private int price;

    public Item(String code, int cost) {
        this.code = code;
        this.price = cost;
    }

    public String getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }
}
