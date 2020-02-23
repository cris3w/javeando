package com.examples.CoreJava.Enums;

import java.util.HashMap;
import java.util.Map;

public enum CustomerType {
    NORMAL("NORMAL"), VIP("VIP");

    private final String repr;

    CustomerType(String repr) {
        this.repr = repr;
    }

    private static final Map<String, CustomerType> stringToEnum = new HashMap<>();

    static {
        for (CustomerType customerType: values())
            stringToEnum.put(customerType.toString(), customerType);
    }

    // returns CustomerType for string, or null if string is invalid
    public static CustomerType fromString(String repr) {
        return stringToEnum.get(repr);
    }

    @Override
    public String toString() {
        return repr;
    }
}
