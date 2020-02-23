package com.examples.DesignPatterns.Behavioral.Strategy;

public class PaypalStrategy implements PaymentStrategy {

    private String email;

    public PaypalStrategy(String email) {
        this.email = email;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using a Paypal account with email " + email);
    }
}
