package com.examples.DesignPatterns.Behavioral.CoR;

// https://medium.com/@antoniojesussg96/implementando-nuestro-propio-motor-de-reglas-java-da7c778ff1f7

public class FizzBuzz {

    private RulesEngine rulesEngine;

    public FizzBuzz() {
        rulesEngine = new RulesEngine();
        rulesEngine.addRule(new FizzBuzzRule());
        rulesEngine.addRule(new FizzRule());
        rulesEngine.addRule(new BuzzRule());
    }

    public String generate(int number) {
        return rulesEngine.evaluateRules(number);
    }
}
