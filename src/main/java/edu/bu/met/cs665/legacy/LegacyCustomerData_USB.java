package edu.bu.met.cs665.legacy;

import java.util.concurrent.TimeUnit;

/**
 * LegacyCustomerData_USB is a concrete implementation of the CustomerData_USB
 * interface.
 * It simulates interaction with the legacy system, where customer data is
 * accessed via USB.
 */
public class LegacyCustomerData_USB implements CustomerData_USB {

    @Override
    public void printCustomer(int customerId) {
        // Code to print customer data, which would be retrieved from a USB-connected
        // system.
        System.out.println("Customer data for ID: " + customerId + " retrieved from USB storage.");
    }

    @Override
    public void getCustomer_USB(int customerId) {
        try {
            // Simulate a longer sleep time to represent a slower response time.
            TimeUnit.SECONDS.sleep(2); // Sleep for 2 seconds
            System.out.println("Retrieving customer data for ID: " + customerId + " from USB storage.");
            // Return a mock customer data object.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("The sleep operation was interrupted.");
        }
    }
}
