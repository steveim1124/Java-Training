import java.util.ArrayList;
import java.util.List;

public class Product {

	private List<Product> productList = new ArrayList<>();
	private String productCode;
	private String description;
	private int stockQty;

	public Product() {

	}

	public Product(String productCode, String description) {
		super();
		this.productCode = productCode;
		this.description = description;
	}

	public boolean addProduct(String productCode, String description) {
		boolean added = false;

		if (productList.size() == 0) {
			productList.add(new Product(productCode, description));
			added = true;
		} else {
			int productCount = productList.size();
			for (int i = 0; i < productCount; i++) {
				if (!productList.get(i).getProductCode().equals(productCode)) {
					productList.add(new Product(productCode, description));
					added = true;
				} else
					System.out.println("not added");
			}
		}
		return added;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStockQty() {
		return stockQty;
	}

	public boolean addStock(String productCode, int qty) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
