package service;

import java.util.List;

import dao.ProductDAO;
import model.Product;

public class ProductService {
	private ProductDAO productDAO = new ProductDAO();

    public void displayAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void displayFilteredProducts(String brand, String category, double minPrice, double maxPrice) {
        List<Product> products = productDAO.getFilteredProducts(brand, category, minPrice, maxPrice);
        if (products.isEmpty()) {
            System.out.println("No products found for the given filters.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

}
