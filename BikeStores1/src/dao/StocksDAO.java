package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import model.Inventory;
import util.DBConnection;

public class StocksDAO {
	
	public Stocks getStockAvailability(int storeId, int productId) {
		Stocks stocks = null;
        String query = "SELECT quantity FROM production.stocks WHERE store_id = ? AND product_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, storeId);
            stmt.setInt(2, productId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	stocks = new Stocks(rs.getInt("storeId"), 
                			rs.getInt("productId"), 
                			rs.getInt("quantity"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving stock: " + e.getMessage());
        }
        return stocks;
    }

}
