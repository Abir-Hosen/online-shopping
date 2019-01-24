package net.abir.shoppingbackend.dao;

import java.util.List;

import net.abir.shoppingbackend.dto.Address;
import net.abir.shoppingbackend.dto.Cart;
import net.abir.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
//	Address getBillingAddress(int userId);
//	List<Address> listShippingAddresses(int userId);
	
	//boolean updateCart(Cart cart);
}
