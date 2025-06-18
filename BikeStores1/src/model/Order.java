package model;

import java.util.List;

public class Order {
	
	private int order_id;
    private int customer_id;
    private int store_id;
    private int staff_id;
    private List<Order_items> items;

    public Order(int order_id, int customer_id, int store_id, int staff_id, List<Order_items> items) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.store_id = store_id;
        this.staff_id = staff_id;
        this.items = items;
    }
    
    public int getOrder_id() {
    	return order_id; 
    }
    public int getCustomer_id() {
    	return customer_id; 
    }
    public int getStore_id() {
    	return store_id; 
    }
    public int getStaff_id() {
    	return staff_id; 
    }
    public List<Order_items> getItems() {
    	return items; 
    }
    
    

    public String toString() {
        return "Order ID: " + order_id + " | Customer ID: " + customer_id + " | Store ID: " + store_id;
    }

	

}
