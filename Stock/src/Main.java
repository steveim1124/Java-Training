
public class Main {

	public static void main(String[] args) {

		Product product = new Product("AB1234", "First Product");
		InventoryController inventoryController = new InventoryController();

		addNewProduct(product, inventoryController);
		addNewProduct(product, inventoryController);
		
		addStock(product, inventoryController, 10);
		addStock(product, inventoryController, 15);
		deductStock(product, inventoryController, 5);
		
		showStockQty(product, inventoryController);
		
//		showProductHistory(product, inventoryController);
	}

	private static void showProductHistory(Product product, InventoryController inventoryController ) {
		inventoryController.showProductHistory(product);
		// ***********  still to do  *************
	}

	private static void showStockQty(Product product, InventoryController inventoryController) {
		inventoryController.showStockQty(product, inventoryController);
		
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
