package com.java.spring.service;

import com.java.spring.model.Customer;
import com.java.spring.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Customer Service - Business logic layer
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    // Constructor Injection - Service depends on Repository
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            customerRepository.save(customer);
            System.out.println("Customer added: " + customer.getName());
        } else {
            System.out.println("Invalid customer data!");
        }
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void removeCustomer(int id) {
        customerRepository.delete(id);
        System.out.println("Customer removed with id: " + id);
    }
}

