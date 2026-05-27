package com.java.spring.main;

import com.java.spring.config.AppConfig;
import com.java.spring.controller.CustomerController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main Application Entry Point
 */
public class Main {
    public static void main(String[] args) {
        // Initialize Spring Context with AppConfig
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerController controller=context.getBean(CustomerController.class);

        System.out.println("===== Customer Management System =====\n");

        // Create some customers
        controller.createCustomer("John Doe", "john@example.com", 9876543210L);
        controller.createCustomer("Jane Smith", "jane@example.com", 9876543211L);
        controller.createCustomer("Bob Wilson", "bob@example.com", 9876543212L);

        // Display all customers
        controller.displayAllCustomers();

        // Get specific customer
        System.out.println();
        controller.getCustomerDetails(1);

        // Delete a customer
        System.out.println();
        controller.deleteCustomer(2);

        // Display updated list
        controller.displayAllCustomers();

        System.out.println("\n===== Application End =====");
    }
}

