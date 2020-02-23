package com.examples.DesignPatterns.Behavioral.CoR;

public class BuzzRule implements Rule {

    @Override
    public boolean canApply(int number) {
        return number % 5 == 0;
    }

    @Override
    public String apply() {
        return "Buzz";
    }
}
