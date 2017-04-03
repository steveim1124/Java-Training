import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	Product product = new Product();
	Inventory inventory = new Inventory();
	
	@Before
	private void setUp(){
		product.addProduct("AB1234", "product one");
		
	}
	
	@Test
	public void addProduct() {
		assertEquals(true, product.addProduct("AB1234", "product one"));
	}
	
	@Test
	public void shouldNotAddProductIfAlreadyAdded(){
		product.addProduct("AB1234", "product one");
		assertEquals(false, product.addProduct("AB1234", "product two"));
	}
	
	@Test
	public void addStockToProduct(){
		product.addProduct("AB1234", "product one");
		assertEquals(true, product.addStock("AB1234", 10));
		assertEquals(10,product.getStockQty());
	}
	
	@Test
	public void showStockQtyForProduct(){
		inventory.addStock("AB1234", 10);
	}

}
