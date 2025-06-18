package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.DBConnection;

public class ProductDAO {
	
	public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT p.product_id, p.product_name, b.brand_name, c.category_name, p.model_year, p.list_price " +
                       "FROM production.products p " +
                       "JOIN production.brands b ON p.brand_id = b.brand_id " +
                       "JOIN production.categories c ON p.category_id = c.category_id";
 
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
 
            while (rs.next()) {
                products.add(new Product( 
                		rs.getString("product_name"),
                        rs.getInt("brand_id"), 
                        rs.getInt("category_id"),
                        rs.getInt("model_year"), 
                        rs.getDouble("list_price")));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
        return products;
    }
	
	public List<Product> getFilteredProducts(String brand, String category, double minPrice, double maxPrice) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT p.product_id, p.product_name, b.brand_name, c.category_name, p.model_year, p.list_price " +
                       "FROM production.products p " +
                       "JOIN production.brands b ON p.brand_id = b.brand_id " +
                       "JOIN production.categories c ON p.category_id = c.category_id " +
                       "WHERE (b.brand_name LIKE ?) AND (c.category_name LIKE ?) AND (p.list_price BETWEEN ? AND ?)";
 
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
 
            stmt.setString(1, "%" + brand + "%");
            stmt.setString(2, "%" + category + "%");
            stmt.setDouble(3, minPrice);
            stmt.setDouble(4, maxPrice);
 
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(rs.getString("product_name"),
                            rs.getInt("brand_id"), 
                            rs.getInt("category_id"),
                            rs.getInt("model_year"), 
                            rs.getDouble("list_price")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error filtering products: " + e.getMessage());
        }
        return products;
    }
 
    

}
