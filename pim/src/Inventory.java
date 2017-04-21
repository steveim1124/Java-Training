import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private String productCode;
	private String mode;
	private int qty;
	private int stockQty; 
	private List<Inventory> record = new ArrayList<>();

	public Inventory() {
	}

	public Inventory(String productCode, String mode, int qty) {
		this.productCode = productCode;
		this.mode = mode;
		this.qty = qty;
	}

	public String processTransaction(String productCode, String mode, int qty) {
		String result = "Error";
		int productLocation = getProductLocation(productCode);
		if (mode == "add") {				
			if (productLocation >= 0) {
				record.get(productLocation).setStockQty(getStockQty() + qty)  ;
				System.out.println("product " + record.get(productLocation).getProductCode()
						+ "qty " + record.get(productLocation).getStockQty());

			} else {
				record.add(new Inventory(productCode, mode, qty));
				stockQty += qty;
			}
			result = "added";
		} else if (mode == "deduct") {
			result = "product code not found";
			if (productLocation >= 0) {
				if (record.get(productLocation).getStockQty() >= qty) {
					record.get(productLocation).setStockQty(getStockQty() - qty);
					record.add(new Inventory(productCode, mode, qty));
					result = "deducted";
				} else
					return "insufficient stock";
			}
			// if(record.indexOf(productCode) > 0){
			// int productLocation = record.indexOf(productCode);
			// if(record.get(productLocation).getStockQty() <= qty){
			// record.get(productLocation).setStockQty(getStockQty() - qty);
			// record.add(new Inventory(productCode,mode, qty));
			// result = "deducted";
			// } else return "insufficient stock";
			// } else return "product code not found";
		}
		return result;
	}

	private int getProductLocation(String productCode) {
		int location = -1;
		for (int i = 0; i < record.size(); i++) {
			if (record.get(i).getProductCode() == productCode) {
				location = i;
			}
		}
		return location;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int qty) {
		this.stockQty = qty;
	}

	public int productTotal(String productCode) {
		return record.get(getProductLocation(productCode)).getStockQty();
	}

//	public boolean addStock(String productCode, int inQty) {
//		int location = getProductLocation(productCode);
//		if (location < 0){
//			
//		}
//		return false;
//	}

}
