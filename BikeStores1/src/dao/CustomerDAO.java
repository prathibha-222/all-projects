package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
 
import model.Customer;
import util.DBConnection;
 
public class CustomerDAO {
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
 
    // Validate email format
    private boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }
 
    // Add a new customer
    public boolean addCustomer(Customer customer) {
        if (!isValidEmail(customer.getEmail())) {
            System.out.println("Invalid email format!");
            return false;
        }
 
        String query = "INSERT INTO sales.customers (first_name, last_name, phone, email, street, city, state, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
 
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
 
            stmt.setString(1, customer.getFirst_name());
            stmt.setString(2, customer.getLast_name());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getStreet());
            stmt.setString(6, customer.getCity());
            stmt.setString(7, customer.getState());
            stmt.setString(8, customer.getZip_code());
 
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
            return false;
        }
    }
 
    // Search customers by name, email, or city
    public List<Customer> searchCustomers(String searchQuery) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM sales.customers WHERE first_name LIKE ? OR last_name LIKE ? OR email LIKE ? OR city LIKE ?";
 
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
 
            stmt.setString(1, "%" + searchQuery + "%");
            stmt.setString(2, "%" + searchQuery + "%");
            stmt.setString(3, "%" + searchQuery + "%");
            stmt.setString(4, "%" + searchQuery + "%");
 
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    customers.add(new Customer(rs.getInt("customer_id"), 
                    		rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("phone"), 
                            rs.getString("email"),
                            rs.getString("street"), 
                            rs.getString("city"), 
                            rs.getString("state"), 
                            rs.getString("zip_code")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching customers: " + e.getMessage());
        }
        return customers;
    }
 
}