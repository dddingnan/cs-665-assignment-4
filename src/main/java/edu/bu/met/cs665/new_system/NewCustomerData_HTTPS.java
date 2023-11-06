package edu.bu.met.cs665.new_system;

import java.util.concurrent.TimeUnit;

/**
 * NewCustomerData_HTTPS is a concrete implementation of the CustomerData_HTTPS
 * interface.
 * It simulates interaction with a RESTful API over HTTPS to manage customer
 * data.
 */
public class NewCustomerData_HTTPS implements CustomerData_HTTPS {

    @Override
    public void printCustomer(int customerId) {
        // Code to print customer data, fetched over HTTPS.
        System.out.println("Customer data for ID: " + customerId + " retrieved via HTTPS.");
    }

    @Override
    public void getCustomer_HTTPS(int customerId) {
        try {
            // Simulate a shorter sleep time to represent a faster response time.
            TimeUnit.MILLISECONDS.sleep(100); // Sleep for 100 milliseconds
            System.out.println("Retrieving customer data for ID: " + customerId + " over HTTPS.");
            // Return a mock customer data object.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("The sleep operation was interrupted.");
        }
    }
}
