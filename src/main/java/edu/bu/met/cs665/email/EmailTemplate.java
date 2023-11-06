package edu.bu.met.cs665.email;

import edu.bu.met.cs665.customer.CustomerType;
import java.util.List;

public class EmailTemplate {
    private String customerType;
    private String message;

    public EmailTemplate(String customerType, String message) {
        this.customerType = customerType;
        this.message = message;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getMessage() {
        return message;
    }

    public static EmailTemplate getTemplateByType(List<EmailTemplate> templates, CustomerType type) {
        for (EmailTemplate template : templates) {
            if (template.getCustomerType().equalsIgnoreCase(type.toString())) {
                return template;
            }
        }
        throw new IllegalArgumentException("Template not found for customer type: " + type);
    }
}
