package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import util.DBConnection;


public class SalesReportDAO {
	
	public Map<Integer, Double> getTotalSalesPerStore() {
        Map<Integer, Double> salesPerStore = new HashMap<>();
        String query = "SELECT store_id, SUM(list_price * quantity * (1 - discount)) AS total_sales FROM sales.order_items " +
                       "JOIN sales.orders ON sales.order_items.order_id = sales.orders.order_id GROUP BY store_id";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                salesPerStore.put(rs.getInt("store_id"), rs.getDouble("total_sales"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching total sales per store: " + e.getMessage());
        }
        return salesPerStore;
    }
	
	public Map<Integer, Integer> getTopSellingProducts() {
        Map<Integer, Integer> topProducts = new HashMap<>();
        String query = "SELECT product_id, SUM(quantity) AS total_quantity FROM sales.order_items GROUP BY product_id";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                topProducts.put(rs.getInt("product_id"), rs.getInt("total_quantity"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching top-selling products: " + e.getMessage());
        }
        return topProducts;
    }
	
	public Map<String, Double> getMonthlySalesTrends() {
        Map<String, Double> monthlySales = new HashMap<>();
        String query = "SELECT DATE_FORMAT(order_date, '%Y-%m') AS month, SUM(list_price * quantity * (1 - discount)) AS total_sales " +
                       "FROM sales.order_items JOIN sales.orders ON sales.order_items.order_id = sales.orders.order_id " +
                       "GROUP BY month ORDER BY month";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                monthlySales.put(rs.getString("month"), rs.getDouble("total_sales"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching monthly sales trends: " + e.getMessage());
        }
        return monthlySales;
    }

}
