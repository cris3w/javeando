package com.examples.DesignPatterns.Behavioral.Strategy;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using a Credit Card with number " + cardNumber);
    }
}
