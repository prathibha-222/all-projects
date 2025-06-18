package model;

import java.util.Map;

public class Salesreport {
	
	private Map<Integer, Double> totalSalesPerStore;
    private Map<Integer, Integer> topSellingProducts;
    private Map<String, Double> monthlySalesTrends;

    public void SalesReport(Map<Integer, Double> totalSalesPerStore, Map<Integer, Integer> topSellingProducts, Map<String, Double> monthlySalesTrends) {
        this.totalSalesPerStore = totalSalesPerStore;
        this.topSellingProducts = topSellingProducts;
        this.monthlySalesTrends = monthlySalesTrends;
    }

    public void displayReport() {
        System.out.println("\n📊 Sales Report:");
        System.out.println("🔹 Total Sales Per Store:");
        totalSalesPerStore.forEach((storeId, total) -> System.out.println("Store " + storeId + ": $" + total));

        System.out.println("\n🔹 Top 5 Selling Products:");
        topSellingProducts.entrySet().stream()
            .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
            .limit(5)
            .forEach(entry -> System.out.println("Product ID: " + entry.getKey() + " | Quantity Sold: " + entry.getValue()));

        System.out.println("\n🔹 Monthly Sales Trends:");
        monthlySalesTrends.forEach((month, sales) -> System.out.println(month + ": $" + sales));
    }

}

