package net.abir.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abir.shoppingbackend.dao.UserDAO;
import net.abir.shoppingbackend.dto.Address;
import net.abir.shoppingbackend.dto.Cart;
import net.abir.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private Address address = null;
	private User user = null;
	private Cart cart = null;	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.abir.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

//	@Test
//	public void testAdd() {
//		
//		user = new User() ;
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("12345");
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));			
//	
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		// linked the address with the user
//		address.setUserId(user.getId());
//		// add address
//		assertEquals("Failed to add the user!", true, userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			
//			cart = new Cart();
//			cart.setUser(user);
//			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//			
//			address = new Address();
//			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//			address.setAddressLineTwo("Near Kudrat Store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			
//			address.setUserId(user.getId());
//			
//			assertEquals("Failed to add  shipping address!", true, userDAO.addAddress(address));
//		}
//	
//	}
	
//	@Test
//	public void testAdd() {
//		
//		user = new User() ;
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("12345");
//
//		if(user.getRole().equals("USER")) {
//			cart = new Cart();
//			cart.setUser(user);
//			user.setCart(cart);
//		}
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//	}
	
//	@Test
//	public void testUpdateCart() {
//		user = userDAO.getByEmail("hr@gmail.com");
//		cart = user.getCart();
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
//	}
	
//	@Test
//	public void testAddAddress() {
//		user = new User() ;
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("12345");
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));			
//	
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		address.setUser(user);
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//		address = new Address();
//		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//		address.setAddressLineTwo("Near Kudrat Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		assertEquals("Failed to add  shipping address!", true, userDAO.addAddress(address));
//	}
	
//	@Test
//	public void testAddAddress() {
//		
//		user = userDAO.getByEmail("hr@gmail.com");
//		
//		address = new Address();
//		address.setAddressLineOne("301/B Jadoo Society, Kishan Kanhaiya Nagar");
//		address.setAddressLineTwo("Near Kudrat Store");
//		address.setCity("Bangalore");
//		address.setState("Karnakata");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		assertEquals("Failed to add  shipping address!", true, userDAO.addAddress(address));
//	}
	
	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("hr@gmail.com");

		assertEquals("Failed to fetch the list of address and size doesn't match!", 2,
				userDAO.listShippingAddresses(user).size());
		
		assertEquals("Failed to fetch the billing address and size doesn't match!", "Mumbai",
				userDAO.getBillingAddress(user).getCity());
	}
	
}
