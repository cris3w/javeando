package com.examples.DesignPatterns.Behavioral.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getTotal() {
        return items.stream().map(Item::getPrice).reduce(0, Integer::sum);
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = getTotal();
        paymentMethod.pay(amount);
    }
}
