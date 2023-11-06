package edu.bu.met.cs665.factory;

import edu.bu.met.cs665.customer.*;
import edu.bu.met.cs665.email.EmailTemplate;

public class CustomerFactory {
    public static Customer createCustomer(CustomerType type, EmailTemplate template) {
        switch (type) {
            case VIP:
                return new VIPCustomer(template);
            // case BUSINESS:
            // return new BusinessCustomer(template);
            // case RETURNING:
            // return new ReturningCustomer(template);
            // case FREQUENT:
            // return new FrequentCustomer(template);
            // case NEW:
            // return new NewCustomer(template);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }
}
