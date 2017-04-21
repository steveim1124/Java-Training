import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {
	
	Inventory record = new Inventory();

//	@Test
//	public void shouldAddQtyToProduct() {
//		assertEquals("added", record.processTransaction("AB1234", "add",10));
//	}
//	
//	@Test
//	public void shouldAddQtyToProductStockQty() {
//		record.processTransaction("AB1234", "add",5);
//		record.processTransaction("AB1234", "add",15);
//		assertEquals(20, record.productTotal("AB1234"));
//	}

	@Test
	public void shouldDeductQtyFromStock(){
		record.processTransaction("AB1234", "add",10);
		assertEquals("deducted",record.processTransaction("AB1234", "deduct",5));
	}
	
//	@Test
//	public void shouldNotDeductQtyFromStockIfProductCodeNotFound(){
//		assertEquals("product code not found",record.processTransaction("AB1234", "deduct",5));
//	}
//	
//	@Test
//	public void shouldNotDeductQtyFromStockIfStockNotAvailable(){
//		record.processTransaction("AB1234", "add",10);
//		assertEquals("insufficient stock",record.processTransaction("AB1234", "deduct",15));
//	}

}
