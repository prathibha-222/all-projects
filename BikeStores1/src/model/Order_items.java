package model;

public class Order_items {
	
	private int product_id;
    private int quantity;
    private double list_price;
    private double discount;

    
	public Order_items(int product_id, double list_price, int quantity, double discount) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.list_price = list_price;
        this.discount = discount;
    }
    public int getProduct_id() {
    	return product_id; 
    }
    public int getQuantity() {
    	return quantity; 
    }
    public double getList_price() {
    	return list_price; 
    }
    public double getDiscount() {
    	return discount; 
    }
    

    public String toString() {
        return "Product ID: " + product_id + " | Quantity: " + quantity + " | Price: $" + list_price + " | Discount: " + discount;
    }

}
