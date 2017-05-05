
public class Product {
	
	String code;
	String description;
	
	public Product(String productCode, String productDescription){
		this.code = productCode;
		this.description = productDescription;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
