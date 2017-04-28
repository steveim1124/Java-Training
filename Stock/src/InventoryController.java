import java.util.ArrayList;
import java.util.List;

public class InventoryController {
	
	private List<Product> productList = new ArrayList<>();
	
	public void addProduct(Product product){
		if (!checkIfProductExists(product.getCode())){
			productList.add(product);
			// do adding product with inventory controller functionality
//			Inventory inventory = new Inventory(productCode);
			System.out.println("Product '" + product.getCode() + "' of description '" + product.getDescription() + "' has been added." );

		} else
			System.out.println("Cannot add product code " + product.getCode() + " as it already exists");
		
	}
	
	private boolean checkIfProductExists(String code){
		boolean productExists = false;
//		System.out.println("product list = " + productList.get(0).toString());
//		if (productList.indexOf(code) != -1){
//		if (productList.contains(code)){
		for (int i = 0; i < productList.size(); i++){
			if (productList.get(i).getCode().toString().equals(code)){
			productExists = true;
			System.out.println("in here");
			}
		}
		return productExists;
	}

}
