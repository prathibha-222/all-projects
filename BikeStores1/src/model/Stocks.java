package model;

public class Stocks {
	private int store_id;
	private int product_id;
	private int quantity;
 
	public Inventory(int store_id, int product_id, int quantity) {
		
	    this.store_id = store_id;
	    this.product_id = product_id;
	    this.quantity = quantity;
	}
	
	public int getStore_id() {
		return store_id;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	    
 
	 public String toString() {
	    return "Store ID: " + store_id + " | Product ID: " + product_id + " | Stock: " + quantity;
	 }

}
