package edu.bu.met.cs665.new_system;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Optional;

import edu.bu.met.cs665.common.CustomerData;

/**
 * NewCustomerData_HTTPS is a concrete implementation of the CustomerData_HTTPS
 * interface.
 * It simulates interaction with a RESTful API over HTTPS to manage customer
 * data.
 */
public class NewCustomerData_HTTPS implements CustomerData_HTTPS {
    private List<CustomerData> customerData;

    public NewCustomerData_HTTPS(List<CustomerData> customerData) {
        this.customerData = customerData;
    }

    @Override
    public void printCustomer(int customerId) {
        Optional<CustomerData> customerOpt = findCustomerById(customerId);
        if (customerOpt.isPresent()) {
            CustomerData customer = customerOpt.get();
            System.out.println("printCustomer - Customer ID: " + customer.getCustomerId() + ", Name: "
                    + customer.getCustomerName());
        } else {
            System.out.println("Customer data for ID: " + customerId + " not found.");
        }
    }

    @Override
    public void getCustomer_HTTPS(int customerId) {
        try {
            // Simulate a shorter sleep time to represent a faster response time.
            TimeUnit.MILLISECONDS.sleep(100);
            Optional<CustomerData> customerOpt = findCustomerById(customerId);
            if (customerOpt.isPresent()) {
                CustomerData customer = customerOpt.get();
                System.out.println("getCustomer_USB - Customer ID: " + customer.getCustomerId() +
                        ", Name: " + customer.getCustomerName());
            } else {
                System.out.println("Customer data for ID: " + customerId + " not found.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("The sleep operation was interrupted.");
        }
    }

    private Optional<CustomerData> findCustomerById(int customerId) {
        return customerData.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst();
    }
}
