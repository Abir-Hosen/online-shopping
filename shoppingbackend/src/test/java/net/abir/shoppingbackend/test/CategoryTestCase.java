package net.abir.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abir.shoppingbackend.dao.CategoryDAO;
import net.abir.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.abir.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category= new Category();
//		
//		category.setName("Laptop");
//		category.setDescription("This is description of Laptop!");
//		category.setImageUrl("Image url 3");
//		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category=categoryDAO.get(1);
//		assertEquals("Successfully fetch a category from the table", "Television", category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category=categoryDAO.get(1);
//		category.setName("TV");
//		assertEquals("Successfully updated the category in the table", true, categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category=categoryDAO.get(1);
//		assertEquals("Successfully deleted the category from the table", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		assertEquals("Successfully fetch the list category from the table",2, categoryDAO.list().size());
//	}
	
	@Test
	public void testCRUDCategory() {
		
		//add cat
		category= new Category();
		category.setName("Laptop");
		category.setDescription("This is description of Laptop!");
		category.setImageUrl("Image url 1");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		category= new Category();
		category.setName("Television");
		category.setDescription("This is description of Television!");
		category.setImageUrl("Image url 2");
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		// update cat
		
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated the category in the table", true, categoryDAO.update(category));
		
		// delete cat
		
		assertEquals("Successfully deleted the category from the table", true, categoryDAO.delete(category));
		
		//list cat
		
		assertEquals("Successfully fetch the list category from the table",1, categoryDAO.list().size());
	}
	
	
}
