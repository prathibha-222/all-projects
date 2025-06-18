package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.Order;
import model.Order_items;
import service.CustomerService;
import service.OrderService;
import service.ProductService;
import service.SalesService;
import service.StocksService;

public class Main {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductService productService = new ProductService();

        CustomerService customerService = new CustomerService();

        OrderService orderService = new OrderService();

        StocksService inventoryService = new StocksService();

        SalesService salesService = new SalesService();
 
        while (true) {

            System.out.println("\n🚴‍♂️ BikeStores Management System");

            System.out.println("1. View All Products");

            System.out.println("2. Filter Products");

            System.out.println("3. Add Customer");

            System.out.println("4. Search Customers");

            System.out.println("5. Place New Order");

            System.out.println("6. Check Product Stock");

            System.out.println("7. Generate Sales Report");

            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
 
            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume newline
 
            switch (choice) {

                case 1:

                    productService.displayAllProducts();

                    break;
 
                case 2:

                    System.out.print("Enter Brand (or leave empty): ");

                    String brand = scanner.nextLine();

                    System.out.print("Enter Category (or leave empty): ");

                    String category = scanner.nextLine();

                    System.out.print("Enter Min Price: ");

                    double minPrice = scanner.nextDouble();

                    System.out.print("Enter Max Price: ");

                    double maxPrice = scanner.nextDouble();

                    scanner.nextLine(); // Consume newline

                    productService.displayFilteredProducts(brand, category, minPrice, maxPrice);

                    break;
 
                case 3:

                    System.out.print("First Name: ");

                    String first_name = scanner.nextLine();

                    System.out.print("Last Name: ");

                    String last_name = scanner.nextLine();

                    System.out.print("Phone: ");

                    String phone = scanner.nextLine();

                    System.out.print("Email: ");

                    String email = scanner.nextLine();

                    System.out.print("Street: ");

                    String street = scanner.nextLine();

                    System.out.print("City: ");

                    String city = scanner.nextLine();

                    System.out.print("State: ");

                    String state = scanner.nextLine();

                    System.out.print("Zip Code: ");

                    String zip_code = scanner.nextLine();

                    Customer newCustomer = new Customer( first_name, last_name, phone, email, city);

                    customerService.addNewCustomer(newCustomer);

                    break;
 
                case 4:

                    System.out.print("Enter name, email, or city to search: ");

                    String searchQuery = scanner.nextLine();

                    customerService.searchCustomers(searchQuery);

                    break;
 
                case 5:

                    System.out.print("Enter Customer ID: ");

                    int customer_id = scanner.nextInt();

                    System.out.print("Enter Store ID: ");

                    int store_id = scanner.nextInt();

                    System.out.print("Enter Staff ID: ");

                    int staff_id = scanner.nextInt();

                    scanner.nextLine(); // Consume newline
 
                    List<Order_items> items = new ArrayList<>();

                    while (true) {

                        System.out.print("Enter Product ID (or 0 to finish): ");

                        int product_id = scanner.nextInt();

                        if (product_id == 0) break;

                        System.out.print("Enter Quantity: ");

                        int quantity = scanner.nextInt();

                        System.out.print("Enter Price: ");

                        double list_price = scanner.nextDouble();

                        System.out.print("Enter Discount: ");

                        double discount = scanner.nextDouble();

                        scanner.nextLine(); // Consume newline

                        items.add(new Order_items(product_id,  list_price,quantity, discount));

                    }
 
                    Order newOrder = new Order(0, customer_id, store_id, staff_id, items);

                    OrderService.processOrder(newOrder);

                    break;
 
                case 6:

                    System.out.print("Enter Store ID: ");

                    int checkStoreId = scanner.nextInt();

                    System.out.print("Enter Product ID: ");

                    int checkProductId = scanner.nextInt();

                    System.out.print("Enter Required Quantity: ");

                    int requiredQuantity = scanner.nextInt();

                    scanner.nextLine(); // Consume newline

                    inventoryService.checkStock(checkStoreId, checkProductId, requiredQuantity);

                    break;
 
                case 7:

                    salesService.generateSalesReport();

                    break;
 
                case 8:

                    System.out.println("Exiting...");

                    scanner.close();

                    System.exit(0);
 
                default:

                    System.out.println("Invalid choice! Try again.");

            }

        }

    }
 
}
