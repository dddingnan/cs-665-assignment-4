package edu.bu.met.cs665.common;

/**
 * CustomerData interface.
 * This interface declares the operations that can be performed on customer
 * data.
 */
public interface CustomerData {
    /**
     * Prints the details of a customer based on the customer ID.
     * 
     * @param customerId the ID of the customer to print
     */
    void printCustomer(int customerId);

    /**
     * Retrieves customer data for a given customer ID.
     * 
     * @param customerId the ID of the customer whose data is to be retrieved
     * @return an object representing the customer's data
     */
    Object getCustomer(int customerId);
}
