package net.abir.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abir.shoppingbackend.dao.ProductDAO;
import net.abir.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.abir.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDProduct() {
//		
//		//create operation
//		
//		//insert
//		product = new Product();
//		product.setName("Oppo Selfie S53");
//		product.setBrand("Oppo");
//		product.setDescription("This is one description for oppo mobile phones");
//		product.setUnitPrice(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		assertEquals("Something went wrong while inserting a new product!",true,productDAO.add(product));
//		
//		//reading & updating
//		product = productDAO.get(2);
//		product.setName("Samsung Galuxy S7");
//		assertEquals("Something went wrong while updating the existing record!", true, productDAO.update(product));
//		
//		//deleting
//		assertEquals("Something went wrong while deleting the product!",true, productDAO.delete(product));
//		
//		//list
//		assertEquals("Something went wrong while fetching the list of product!",10, productDAO.list().size());
//	}
	
	@Test
	public void testListActiveProduct() {
		assertEquals("Something went wrong while fetching the list of product!",4, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while featching the list of product!",3,productDAO.listActiveProductByCategory(3).size());
		assertEquals("Something went wrong while featching the list of products!",1,productDAO.listActiveProductByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",3,productDAO.getLatestActiveProducts(3).size());
	}
	

}
