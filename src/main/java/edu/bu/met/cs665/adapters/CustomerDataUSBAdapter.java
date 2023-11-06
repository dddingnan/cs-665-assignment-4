package edu.bu.met.cs665.adapters;

import edu.bu.met.cs665.new_system.CustomerData_HTTPS;
import edu.bu.met.cs665.legacy.LegacyCustomerData_USB;

/**
 * Adapter for the legacy CustomerData_USB interface, adapting it to the new
 * CustomerData_HTTPS interface.
 */
public class CustomerDataUSBAdapter implements CustomerData_HTTPS {

    private final LegacyCustomerData_USB legacyCustomerData;

    public CustomerDataUSBAdapter(LegacyCustomerData_USB legacyCustomerData) {
        this.legacyCustomerData = legacyCustomerData;
    }

    @Override
    public void printCustomer(int customerId) {
        // Delegate the call to the legacy system's printCustomer method.
        legacyCustomerData.printCustomer(customerId);
    }

    @Override
    public void getCustomer_HTTPS(int customerId) {
        // Delegate the call to the legacy system's getCustomer_USB method.
        // This adapter method is making the legacy USB system appear as if it is the
        // newer HTTPS system.
        legacyCustomerData.getCustomer_USB(customerId);
    }
}
