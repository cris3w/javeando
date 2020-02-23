package com.examples.DesignPatterns.Behavioral.CoR;

public class FizzRule implements Rule {

    @Override
    public boolean canApply(int number) {
        return number % 3 == 0;
    }

    @Override
    public String apply() {
        return "Fizz";
    }
}
