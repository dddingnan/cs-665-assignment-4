/**
 * Name: Dingnan Hsu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/03/2023
 * File Name: Main.java
 * Description: The main driver class of the application. It simulates the functionality of a delivery request system
 * where retailers can send out delivery requests to drivers. This application utilizes the Observer design pattern
 * to notify drivers of new delivery requests.
 */
package edu.bu.met.cs665;

import edu.bu.met.cs665.exception.InvalidDataException;
import edu.bu.met.cs665.factory.CustomerFactory;
import edu.bu.met.cs665.loader.FileLoader;
import edu.bu.met.cs665.customer.Customer;
import edu.bu.met.cs665.customer.CustomerType;
import edu.bu.met.cs665.email.*;

import java.util.List;

public class Main {

  /**
   * Entry point method for the application. This method initializes the system
   * by:
   * 1. Loading driver details from a CSV file.
   * 2. Registering the drivers as observers to a shop.
   * 3. Broadcasting a delivery request to the drivers.
   * 4. Modifying the list of drivers.
   * 5. Broadcasting another delivery request.
   * 
   * @param args The command line arguments.
   * @throws InvalidDataException If there's an issue loading data.
   * @throws InterruptedException If there's an interrupted exception.
   */
  public static void main(String[] args) throws InvalidDataException, InterruptedException {
    FileLoader loader = new FileLoader();
    List<EmailTemplate> templates = loader.loadEmailTemplates("src/data/email_templates.csv");

    // Displaying the loaded templates
    System.out.println("Loaded Email Templates:");
    for (EmailTemplate template : templates) {
      System.out.println("Customer Type: " + template.getCustomerType());
      System.out.println("Message: " + template.getMessage());
      System.out.println("---------------------------");
    }

    // TODO Create more customer and write the juni test.
    // Using Enum to create a VIP customer
    EmailTemplate vipTemplate = EmailTemplate.getTemplateByType(templates, CustomerType.VIP);
    Customer vip = CustomerFactory.createCustomer(CustomerType.VIP, vipTemplate);
    System.out.println("Customer Type: " + vip.getType());
    System.out.println("Email: " + vip.getEmailMessage());

  }
}
