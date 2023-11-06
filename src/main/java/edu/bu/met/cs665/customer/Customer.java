package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.EmailTemplate;

public abstract class Customer {
    protected EmailTemplate template;

    public Customer(EmailTemplate template) {
        this.template = template;
    }

    public abstract String getType();

    public String getEmailMessage() {
        return template.getMessage();
    }
}