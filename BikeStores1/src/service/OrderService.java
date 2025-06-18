package service;
 
import dao.OrderDAO;
import model.Order;
 
public class OrderService {
	private static OrderDAO orderDAO = new OrderDAO();
 
    public static void processOrder(Order order) {
        if (orderDAO.placeOrder(order)) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Failed to place order.");
        }
    }
 
}