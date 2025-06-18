package model;

public class Product {
	//private int product_id;
    private String product_name;
    private int brand_id;
    private int category_id;
    private int model_year;
    private double list_price;

    public Product(String product_name, int brand_id, int category_id, int model_year, double list_price) {
        //this.product_id = product_id;
        this.product_name = product_name;
        this.brand_id = brand_id;
        this.category_id = category_id;
        this.model_year = model_year;
        this.list_price = list_price;
    }

    @Override
    public String toString() {
        return product_name + " | Brand: " + brand_id + " | Category: " + category_id +
                " | Year: " + model_year + " | Price: $" + list_price;
    }

}
