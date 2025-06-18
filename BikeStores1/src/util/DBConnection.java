package util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/BikeStores";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Password@12";
 
	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Database connected successfully!");
	        } catch (SQLException e) {
	            System.out.println("Failed to connect to the database!");
	            e.printStackTrace();
	        }
	        return conn;
	    }
 
	    public static void main(String[] args) {
	        Connection conn = getConnection();
	        if (conn != null) {
	            try {
	                conn.close();
	                System.out.println("Connection closed.");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
