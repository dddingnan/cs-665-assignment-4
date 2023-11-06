package edu.bu.met.cs665.legacy;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import edu.bu.met.cs665.common.CustomerData;

/**
 * LegacyCustomerData_USB is a concrete implementation of the CustomerData_USB
 * interface.
 * It simulates interaction with the legacy system, where customer data is
 * accessed via USB.
 */
public class LegacyCustomerData_USB implements CustomerData_USB {
    private List<CustomerData> customerData;

    public LegacyCustomerData_USB(List<CustomerData> customerData) {
        this.customerData = customerData;
    }

    // TODO Here
    @Override
    public void printCustomer(int customerId) {
        Optional<CustomerData> customer = customerData.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst();
        if (customer.isPresent()) {
            System.out.println("Customer data for ID: " + customerId + ": " + customer.get());
        } else {
            System.out.println("Customer data for ID: " + customerId + " not found.");
        }
    }

    @Override
    public void getCustomer_USB(int customerId) {
        try {
            // Simulate a longer sleep time to represent a slower response time.
            TimeUnit.SECONDS.sleep(2); // Sleep for 2 seconds
            Optional<CustomerData> customer = customerData.stream()
                    .filter(c -> c.getCustomerId() == customerId)
                    .findFirst();
            if (customer.isPresent()) {
                System.out.println("Retrieved customer data for ID: " + customerId + ": " + customer.get());
            } else {
                System.out.println("Customer data for ID: " + customerId + " not found.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("The sleep operation was interrupted.");
        }
    }
}
