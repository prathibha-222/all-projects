package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Order;
import model.Order_items;
import util.DBConnection;

public class OrderDAO {
	
	public boolean placeOrder(Order order) {
        String orderQuery = "INSERT INTO sales.orders (customer_id, order_status, order_date, required_date, store_id, staff_id) VALUES (?, ?, ?, ?, ?, ?)";
        String orderItemQuery = "INSERT INTO sales.order_items (order_id, item_id, product_id, quantity, list_price, discount) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement orderStmt = null;
        PreparedStatement orderItemStmt = null;
        int order_id = -1;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Insert Order
            orderStmt = conn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setInt(1, order.getCustomer_id());
            orderStmt.setInt(2, 1); 
            orderStmt.setDate(3, new Date(System.currentTimeMillis()));
            orderStmt.setDate(4, new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000))); // Required in 7 days
            orderStmt.setInt(5, order.getStore_id());
            orderStmt.setInt(6, order.getStaff_id());
            orderStmt.executeUpdate();

            // Retrieve Generated Order ID
            try (ResultSet rs = orderStmt.getGeneratedKeys()) {
                if (rs.next()) {
                    order_id = rs.getInt(1);
                }
            }

            if (order_id == -1) {
                throw new SQLException("Failed to generate order ID.");
            }

            // Insert Order Items
            orderItemStmt = conn.prepareStatement(orderItemQuery);
            int itemId = 1;
            for (Order_items item : order.getItems()) {
                orderItemStmt.setInt(1, order_id);
                orderItemStmt.setInt(2, itemId++);
                orderItemStmt.setInt(3, item.getProduct_id());
                orderItemStmt.setInt(4, item.getQuantity());
                orderItemStmt.setDouble(5, item.getList_price());
                orderItemStmt.setDouble(6, item.getDiscount());
                orderItemStmt.executeUpdate();
            }

            conn.commit(); 
            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); 
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback failed: " + rollbackEx.getMessage());
                }
            }
            System.out.println("Order placement failed: " + e.getMessage());
            return false;
        } finally {
            try {
                if (orderStmt != null) orderStmt.close();
                if (orderItemStmt != null) orderItemStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }
    }

}
