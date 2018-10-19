package net.abir.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.abir.shoppingbackend.dao.CategoryDAO;
import net.abir.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	public static List<Category> categories=new ArrayList<>();
	
	static {
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is description of Television!");
		category.setImageUrl("Image url 1");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description of Mobile!");
		category.setImageUrl("Image url 2");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is description of Laptop!");
		category.setImageUrl("Image url 3");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category : categories) {
			if(category.getId()==id) {
				return category;
			}
		}
		return null;
	}

}
