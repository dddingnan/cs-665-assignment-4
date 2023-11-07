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

import java.util.List;

import edu.bu.met.cs665.exception.InvalidDataException;
import edu.bu.met.cs665.legacy.LegacyCustomerData_USB;
import edu.bu.met.cs665.loader.FileLoader;
import edu.bu.met.cs665.new_system.CustomerData_HTTPS;
import edu.bu.met.cs665.new_system.NewCustomerData_HTTPS;
import edu.bu.met.cs665.adapters.CustomerDataUSBAdapter;
import edu.bu.met.cs665.common.CustomerData;

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
    List<CustomerData> customers = loader.loadCustomer("src/data/customer.csv");
    System.out.println("---------------------------");

    LegacyCustomerData_USB legacySystem = new LegacyCustomerData_USB(customers);

    NewCustomerData_HTTPS newSystem = new NewCustomerData_HTTPS(customers);

    // Now you can use legacySystem to print a customer or get a customer by ID.
    int customerId = 1; // Example customer ID.
    legacySystem.printCustomer(customerId);
    legacySystem.getCustomer_USB(customerId);

    System.out.println("---------------------------");

    // // Now you can use legacySystem to print a customer or get a customer by ID.
    newSystem.printCustomer(customerId);
    newSystem.getCustomer_HTTPS(customerId);

    System.out.println("---------------------------");
    // Use the adapter to interact with the legacy system as if it were the new
    // HTTPS system
    CustomerData_HTTPS adapter = new CustomerDataUSBAdapter(legacySystem);
    adapter.printCustomer(customerId);
    adapter.getCustomer_HTTPS(customerId);
  }
}
