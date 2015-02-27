package com.example.presentation;


import com.example.model.Customer;
import com.example.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @RequestMapping(value = "/customerList", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Customer> customerList = customerRepository.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/customerList";
    }

    @RequestMapping(value = "/customerEdit", method = RequestMethod.GET )
    public String edit(Model model, @RequestParam("id") Long id) {
        Customer customer = customerRepository.findOne(id);
        model.addAttribute("customer", customer);
        return "customer/customerEdit";
    }

    @RequestMapping(value = "/customerUpdate", method = RequestMethod.POST )
    public String update(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("id") Long id) {
        Customer customer = customerRepository.findOne(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        return "redirect:customerList.do";
    }

    @RequestMapping(value = "/customerCreate", method = RequestMethod.GET )
    public String create() {
        return "customer/customerCreate";
    }

    @RequestMapping(value = "/customerInsert", method = RequestMethod.POST )
    public String insert(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        return "redirect:customerList.do";
    }

    @RequestMapping(value = "/customerDelete", method = RequestMethod.GET )
    public String delete(@RequestParam("id") Long id) {
        customerRepository.delete(id);
        return "redirect:customerList.do";
    }

}
