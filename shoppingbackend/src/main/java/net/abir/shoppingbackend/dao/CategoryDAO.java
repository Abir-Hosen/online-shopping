package net.abir.shoppingbackend.dao;

import java.util.List;

import net.abir.shoppingbackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);

}
