package edu.bu.met.cs665.common;

/**
 * CustomerData interface.
 * This interface declares the operations that can be performed on customer
 * data.
 */
public class CustomerData {
    private String customerId;
    private String customerName;

    /**
     * Constructs an EmailTemplate with a specified customer type and message.
     * 
     * @param customerId   Type of customer the template is for.
     * @param customerName Email message template.
     */
    public CustomerData(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    /**
     * Retrieves the customer type of this template.
     * 
     * @return Customer type as a string.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Retrieves the message of this template.
     * 
     * @return Message as a string.
     */
    public String getCustomerName() {
        return customerName;
    }
}
