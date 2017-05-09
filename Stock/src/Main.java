
public class Main {

	public static void main(String[] args) {
		InventoryController inventoryController = new InventoryController();

		Product product = new Product("AB1234", "First Product");

		addNewProduct(product, inventoryController);
		addNewProduct(product, inventoryController);
		
		addStock(product, inventoryController, 10);
		addStock(product, inventoryController, 15);
		deductStock(product, inventoryController, 5);
		
		showStockQty(product, inventoryController);
		
		showProductHistory(product, inventoryController);
		
		Product product2 = new Product("XY9876", "Last Product");

		addNewProduct(product2, inventoryController);
		
		addStock(product2, inventoryController, 100);
		addStock(product2, inventoryController, 150);
		deductStock(product2, inventoryController, 500);
		deductStock(product2, inventoryController, 50);
		
		showStockQty(product2, inventoryController);
		
		showProductHistory(product2, inventoryController);
	}

	private static void showProductHistory(Product product, InventoryController inventoryController ) {
		inventoryController.showProductHistory(product.getCode());
	}

	private static void showStockQty(Product product, InventoryController inventoryController) {
		inventoryController.showStockQty(product);
		
	}

	private static void deductStock(Product product, InventoryController inventoryController, int qtyOut) {
		inventoryController.deductstock(product, qtyOut);
	}

	private static void addStock(Product product, InventoryController inventoryController, Integer qtyIn) {
		inventoryController.addstock(product, qtyIn);
	}

	private static void addNewProduct(Product product, InventoryController inventoryController) {
		inventoryController.addProduct(product);
	}

}
