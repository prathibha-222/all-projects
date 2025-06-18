package model;
 
public class Customer {
	private int customer_id;
	private String first_name;
    private String last_name;
    private String phone ;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip_code;
 
    public Customer(int customer_id, String first_name, String last_name, String email, String phone , String street , String city , String state , String zip_code){
    	this.customer_id=customer_id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.phone=phone;
        this.street=street;
        this.city=city;
        this.state=state;
        this.zip_code=zip_code;
    }
    
    public int getCustomer_id() {
    	return customer_id;
    }
    
    public String getFirst_name(){
       return first_name;
    }
    
    public String getLast_name(){
        return last_name;
    }
   
    public String getEmail(){
        return email;
    }
   
    public String getPhone(){
        return phone;
    }
    
    public String getStreet() {
    	return street;
    }
 
    public String getCity(){
        return city;
    }
    
    public String getState() {
    	return state;
    }
    
    public String getZip_code() {
    	return zip_code;
    }
 
 
    @Override public String toString(){
    	 return "Customer ID: " + customer_id + " | Name: " + first_name + " " + last_name + " | Email: " + email + " | City: " + city;
    }
 
}
