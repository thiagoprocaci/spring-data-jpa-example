package com.example.model;


import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerTest {

    @Test
    public void testConstructor() {
        Customer customer = new Customer();
        assertNull(customer.getFirstName());
        assertNull(customer.getLastName());
        assertEquals(0L, customer.getId());

        customer = new Customer("first", "last");
        assertEquals("first",customer.getFirstName());
        assertEquals("last", customer.getLastName());
        assertEquals(0L, customer.getId());

    }

    @Test
    public void testToString() {
        Customer customer = new Customer("first", "last");
        customer.setId(2L);
        assertEquals(String.format("Customer[id=%d, firstName='%s', lastName='%s']",2L, "first", "last"), customer.toString());
    }

}
