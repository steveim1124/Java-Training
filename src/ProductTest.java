import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	Product product = new Product();
	
//	@Test
//	public void addProduct() {
//		assertEquals(true, product.addProduct("AB1234", "product one"));
//	}
//	
//	@Test
//	public void shouldNotAddDuplicateProduct() {
//		assertEquals(false, product.addProduct("AB1234", "product one"));
//	}
//	
//	@Test
//	public void shouldNotAddProductIfAlreadyAdded(){
//		assertEquals(false, product.addProduct("AB1234", "product two"));
//	}
//	
	@Test
	public void addStockToProduct(){
		
		product.addProduct("AB1234", "product one");
		
		String result = null;
		for(int i = 0; i<3;i++){
			result = product.addStock("AB1234", 10);
			System.out.println(i + " result = " + result);
		}
		assertEquals("added", result);
		assertEquals(30,product.getStockQty("AB1234"));
	}

}
