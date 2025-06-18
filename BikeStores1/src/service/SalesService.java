package service;
 
import java.util.Map;
 
import dao.SalesDAO;
import model.SalesReport;
 
public class SalesService {
	private SalesDAO salesDAO = new SalesDAO();
 
    public void generateSalesReport() {
        Map<Integer, Double> totalSalesPerStore = salesDAO.getTotalSalesPerStore();
        Map<Integer, Integer> topSellingProducts = salesDAO.getTopSellingProducts();
        Map<String, Double> monthlySalesTrends = salesDAO.getMonthlySalesTrends();
 
        SalesReport report = new SalesReport(totalSalesPerStore, topSellingProducts, monthlySalesTrends);
        report.displayReport();
    }
 
}
