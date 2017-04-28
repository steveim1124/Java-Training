
public class Main {

	public static void main(String[] args) {

		Product product = new Product("AB1234", "First Product");

		addNewProduct(product);
		addNewProduct(product);

	}

	private static void addNewProduct(Product product) {
		InventoryController inventory = new InventoryController();
		inventory.addProduct(product);
	//	System.out.println("Added product " + product.getCode() + " - " + product.getDescription());

	}

}
