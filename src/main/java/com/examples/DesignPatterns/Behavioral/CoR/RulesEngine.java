package com.examples.DesignPatterns.Behavioral.CoR;

import java.util.ArrayList;

public class RulesEngine {

    private ArrayList<Rule> rulesEngine;

    public RulesEngine() {
        rulesEngine = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rulesEngine.add(rule);
    }

    // Java 8 version
    public String evaluateRules(int number) {
        return rulesEngine.stream()
                .filter(rule -> rule.canApply(number))
                .findFirst()
                .map(Rule::apply)
                .orElse(String.valueOf(number));
    }

    // original version
    public String executeRules(int number) {
        for (Rule rule : rulesEngine) {
            if (rule.canApply(number)) {
                return rule.apply();
            }
        }
        return String.valueOf(number);
    }
}
