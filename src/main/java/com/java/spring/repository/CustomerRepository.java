package com.java.spring.repository;

import com.java.spring.model.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer Repository - Handles data access
 */
@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();
    private int nextId = 1;

    public void save(Customer customer) {
        customer.setId(nextId++);
        customers.add(customer);
    }

    public Customer findById(int id) {
        return customers.stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    public void delete(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
}

