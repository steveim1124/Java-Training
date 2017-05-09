import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class InventoryController {

	private static final String HAS_BEEN_ADDED_LABEL = "' has been added.";
	private static final String STOCK_DECREASED_LABEL = "' stock decreased by ";
	private static final String STOCK_INCREASED_LABEL = "' stock increased by ";
	private static final String DESCRIPTION_LABEL = "' of description '";
	private static final String PRODUCT_LABEL = "Product '";

	Map<Product, Integer> productStock = new HashMap<>();
	List<String> productHistory = new ArrayList<>();

	public void addProduct(Product product) {
		if (!checkIfProductExists(product.getCode())) {
			productStock.put(product, 0);
			logProductHistory(product, 0, HAS_BEEN_ADDED_LABEL);
			displayToScreen(product, 0, HAS_BEEN_ADDED_LABEL);
		} else
			System.out.println("Cannot add product code " + product.getCode() + " as it already exists");
	}

	public void addstock(Product product, Integer qtyIn) {
		if (checkIfProductExists(product.getCode())) {
			productStock.replace(product, productStock.get(product) + qtyIn);
			logProductHistory(product, qtyIn, STOCK_INCREASED_LABEL);
			displayToScreen(product, qtyIn, STOCK_INCREASED_LABEL);

		} else
			System.out.println("Product " + product.getCode() + " does not exist");
	}

	private void displayToScreen(Product product, Integer qtyIn, String mode) {
		System.out.println(
				PRODUCT_LABEL + product.getCode() + DESCRIPTION_LABEL + product.getDescription() + mode + qtyIn);
		System.out.println("Product stock = " + productStock.get(product));
	}

	private void logProductHistory(Product product, Integer qtyIn, String mode) {
		productHistory
				.add(PRODUCT_LABEL + product.getCode() + DESCRIPTION_LABEL + product.getDescription() + mode + qtyIn);
	}

	public void deductstock(Product product, Integer qtyOut) {
		if (checkIfProductExists(product.getCode())) {
			int currentStock = productStock.get(product);
			if (currentStock >= qtyOut) {
				productStock.replace(product, currentStock - qtyOut);
				logProductHistory(product, qtyOut, STOCK_DECREASED_LABEL);
				displayToScreen(product, qtyOut, STOCK_DECREASED_LABEL);
			} else {
				System.out.println(
						"Insufficient stock of product " + product.getCode() + ". Current stock is " + currentStock);
			}
		} else
			System.out.println("Product " + product.getCode() + " does not exist");
	}

	private boolean checkIfProductExists(String code) {
		boolean productExists = false;
		if (!productStock.isEmpty()) {
			for (Entry<Product, Integer> product : productStock.entrySet()) {
				if (product.getKey().getCode().equals(code)) {
					productExists = true;
					if (productExists)
						break;
				}
			}
		}
		return productExists;
	}

	public void showStockQty(Product product) {
		System.out.println("Stock qty for product " + product.getCode() + " is " + productStock.get(product));
	}

	public void showProductHistory(String code) {
		if (!productHistory.isEmpty()) {
			System.out.println("***** Product History For " + code + " ********");
			for (int i = 0; i < productHistory.size(); i++) {
				if (productHistory.get(i).contains(code)) {
					System.out.println(productHistory.get(i));
				}
			}
		}

	}

}
