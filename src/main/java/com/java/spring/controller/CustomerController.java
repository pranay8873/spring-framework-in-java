package com.java.spring.controller;

import com.java.spring.model.Customer;
import com.java.spring.service.CustomerService;
import org.springframework.stereotype.Controller;

/**
 * Customer Controller - Handles customer operations
 */
@Controller
public class CustomerController {

    private CustomerService customerService;

    // Constructor Injection - Controller depends on Service
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(String name, String email, long phone) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customerService.addCustomer(customer);
    }

    public void displayAllCustomers() {
        System.out.println("\n=== All Customers ===");
        customerService.getAllCustomers().forEach(c ->
            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() +
                             ", Email: " + c.getEmail() + ", Phone: " + c.getPhone())
        );
    }

    public void getCustomerDetails(int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer != null) {
            System.out.println("Customer: " + customer.getName() + " (" + customer.getEmail() + ")");
        } else {
            System.out.println("Customer not found!");
        }
    }

    public void deleteCustomer(int id) {
        customerService.removeCustomer(id);
    }
}

