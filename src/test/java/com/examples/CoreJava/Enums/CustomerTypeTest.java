package com.examples.CoreJava.Enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CustomerTypeTest {

    @Test
    public void GivenValidStringWhenCreateEnumFromStringThenEnumIsCreated() {
        assertEquals(CustomerType.fromString("VIP"), CustomerType.VIP);
    }

    @Test
    public void GivenInvalidStringWhenCreateEnumFromStringThenReturnNull() {
        assertNull(CustomerType.fromString("invalid"));
    }
}
