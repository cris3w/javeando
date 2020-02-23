package com.examples.DesignPatterns.Behavioral.CoR;

public interface Rule {

    boolean canApply(int number);

    String apply();
}
