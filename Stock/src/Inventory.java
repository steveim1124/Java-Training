import java.util.HashMap;
import java.util.Map;

public class Inventory {
	String productCode;
	Integer stockQty;
	Map<String, Integer> productStock = new HashMap<String, Integer>();
	Map<String, Integer> productHistory = new HashMap<String, Integer>();
	
	public Inventory(String prodctCode, Integer qty){
		this.productCode = prodctCode;
		this.stockQty = qty;
	}

	public Inventory(String productCode) {
		this.productCode = productCode;
		this.stockQty = 0;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getStockQty() {
		return stockQty;
	}

	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}

	public void addStock(String productCode, Integer qtyIn) {
		productStock.put(productCode, productStock.getOrDefault(productCode, getStockQty()) + qtyIn);
		productHistory.put(productCode, qtyIn);
		System.out.println("Stock of qty " + qtyIn + " has been added to product " + productCode + ". Stock total is now "
		+ productStock.get(productCode));
	}
	
	public void deductStock(String productCode, Integer qtyOut) {
		productStock.put(productCode, productStock.getOrDefault(productCode, getStockQty()) + qtyOut);
		productHistory.put(productCode, qtyOut);
		System.out.println("A qty of " + qtyOut + " has been deducted from product " + productCode + ". Stock total is now "
		+ productStock.get(productCode));
	}
	
	public Integer showStockQty(String productCode){
		return productStock.get(productCode);
	}

	public void showProductHistory(Product product) {
		int historyTotal = productHistory.size();
		System.out.println("===== Product History =====");
		for (int i = 0; i < historyTotal; i ++){
			System.out.println("Product " + product.getCode() + " qty " + productHistory.get(product.getCode()));
		}
		
	}
	
}
