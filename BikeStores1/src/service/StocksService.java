package service;
 
import dao.InventoryDAO;

import model.Inventory;
 
public class InventoryService {

	 private InventoryDAO inventoryDAO = new InventoryDAO();
 
	    // Check stock availability before placing an order

	    public boolean checkStock(int storeId, int productId, int requiredQuantity) {

	        Inventory inventory = inventoryDAO.getStockAvailability(storeId, productId);
 
	        if (inventory == null) {

	            System.out.println("Product not found in store inventory.");

	            return false;

	        }
 
	        if (inventory.getQuantity() >= requiredQuantity) {

	            System.out.println("✅ Stock available: " + inventory.getQuantity() + " units.");

	            return true;

	        } else {

	            System.out.println("⚠️ Insufficient stock! Available: " + inventory.getQuantity() + ", Required: " + requiredQuantity);

	            return false;

	        }

	    }
 
}
 