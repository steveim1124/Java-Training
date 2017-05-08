import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class InventoryController {

	// private List<Product> productList = new ArrayList<>();
	// private Inventory inventory;

	Map<Product, Integer> productStock = new HashMap<>();
	List<String> productHistory = new ArrayList<>();

	public void addProduct(Product product) {
		if (!checkIfProductExists(product.getCode(), product.getDescription())) {
			productStock.put(product, 0);
			productHistory.add("Product '" + product.getCode() + "' of description '" + product.getDescription()
			+ "' has been added.");
			System.out.println("Product '" + product.getCode() + "' of description '" + product.getDescription()
					+ "' has been added.");
		} else
			System.out.println("Cannot add product code " + product.getCode() + " as it already exists");
	}

	public void addstock(Product product, Integer qtyIn) {
		if (checkIfProductExists(product.getCode(), product.getDescription())) {
//			String pcode = product.getCode();
			int currentStock = productStock.get(product);
			productStock.replace(product, currentStock + qtyIn);
			productHistory.add("Product '" + product.getCode() + "' of description '" + product.getDescription()
					+ "' stock increased by " + qtyIn);
			System.out.println("Product '" + product.getCode() + "' of description '" + product.getDescription()
			+ "' stock increased by " + qtyIn);
			System.out.println("Product stock = " + productStock.get(product));

		} else
			System.out.println("Product " + product.getCode() + " does not exist");
	}

	public void deductstock(Product product, Integer qtyOut) {
		if (checkIfProductExists(product.getCode(), product.getDescription())) {
			int currentStock = productStock.get(product);
			if (currentStock >= qtyOut) {
				productStock.replace(product, currentStock - qtyOut);
				productHistory.add("Product '" + product.getCode() + "' of description '" + product.getDescription()
						+ "' stock decreased by " + qtyOut);
				System.out.println("Product '" + product.getCode() + "' of description '" + product.getDescription()
				+ "' stock decreased by " + qtyOut);
			} else {
				System.out.println(
						"Insufficient stock of product " + product.getCode() + ". Current stock is " + currentStock);
			}
		} else
			System.out.println("Product " + product.getCode() + " does not exist");
	}

	private boolean checkIfProductExists(String code, String description) {
		boolean productExists = false;
		if (!productStock.isEmpty()) {
			for (Entry<Product, Integer> product : productStock.entrySet()) {
				if (product.getKey().getCode().equals(code)) {
					productExists = true;
				}
			}
		}
		return productExists;
	}

	public void showStockQty(Product product, InventoryController inventoryController) {
		System.out.println("Stock qty for product " + product.getCode() + " is " + productStock.get(product));
	}

	public void showProductHistory(String code) {
		if (!productHistory.isEmpty()) {
	for (int i = 0; i < productHistory.size(); i++ ) {
		if (productHistory.get(i).contains(code)) {
			System.out.println(productHistory.get(i));
		}
	}
}

	}

}
