package com.example.presentation;


import com.example.model.Customer;
import com.example.persistence.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CustomerControllerTest {


    private CustomerRepository customerRepository;
    private CustomerController customerController;

    @Before
    public void doBefore() {
        customerController = new CustomerController();
        customerRepository = mock(CustomerRepository.class);
        customerController.setCustomerRepository(customerRepository);
    }


    @Test
    public void testFindAll() {
        List<Customer> customerList = new ArrayList<>();
        Customer c = new Customer();
        c.setId(2L);
        customerList.add(c);
        Model model = mock(Model.class);
        when(customerRepository.findAll()).thenReturn(customerList);
        assertEquals("customer/customerList", customerController.findAll(model));

        InOrder order = inOrder(customerRepository, model);

        order.verify(customerRepository).findAll();
        order.verify(model).addAttribute("customerList", customerList);
    }

    @Test
    public void testEdit() {
       Customer c = new Customer();
       c.setId(2L);
       long id =  c.getId();
       Model model = mock(Model.class);
       when(customerRepository.findOne(id)).thenReturn(c);

       assertEquals("customer/customerEdit", customerController.edit(model, id));
       InOrder order = inOrder(customerRepository, model);
       order.verify(customerRepository).findOne(id);
       order.verify(model).addAttribute("customer", c);

    }

    @Test
    public void testUpdate() {
        Customer c = mock(Customer.class);
        long id =  2L;
        String firstName = "first";
        String lastName = "last";
        when(customerRepository.findOne(id)).thenReturn(c);

        assertEquals("redirect:customerList.do", customerController.update(firstName, lastName, id));

        verify(customerRepository).findOne(id);
        verify(c).setFirstName(firstName);
        verify(c).setLastName(lastName);
        verify(customerRepository).save(c);
    }

    @Test
    public void testCreate() {
        assertEquals("customer/customerCreate", customerController.create());
    }

    @Test
    public void testInsert() {
        String firstName = "first";
        String lastName = "last";
        assertEquals("redirect:customerList.do", customerController.insert(firstName, lastName));
        verify(customerRepository).save(any(Customer.class));
    }

    @Test
    public void testDelete() {
        long id =  2L;
        assertEquals("redirect:customerList.do", customerController.delete(id));
        verify(customerRepository).delete(id);

    }
}
