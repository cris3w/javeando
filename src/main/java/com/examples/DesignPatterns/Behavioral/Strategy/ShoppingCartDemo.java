package com.examples.DesignPatterns.Behavioral.Strategy;

// https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial

public class ShoppingCartDemo {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1", 40);
        Item item2 = new Item("2", 15);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("test@example.com"));
        cart.pay(new CreditCardStrategy("4111111111111111"));
    }
}
