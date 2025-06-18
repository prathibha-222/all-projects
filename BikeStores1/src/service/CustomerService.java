package service;

import java.util.List;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {
	private CustomerDAO customerDAO = new CustomerDAO();

    public void addNewCustomer(Customer customer) {
        if (customerDAO.addCustomer(customer)) {
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Failed to add customer.");
        }
    }

    public void searchCustomers(String searchQuery) {
        List<Customer> customers = customerDAO.searchCustomers(searchQuery);
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

}
