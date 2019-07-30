package com.zensar.daos;

import java.util.List;

import com.zensar.entities.Product;

/*
 * Author: Nishita Khandelwal
 * Creation Date: 29th July 2019 5.55PM
 * Modified Date: 29th July 2019 9.50AM
 * Version: 3.0
 * Copyright: Zensar Technologies. Alll rights reserved. 
 * Description: Represents data access object interface
 * used by business layer
 * it contains CRUD operation method for entity product.
 * 
 * */

public interface ProductDao {
	
	void insert(Product product);
	void update(Product product);
	void delete(Product product);
	Product getById(int ProductId);
	List<Product> getAll();
	

}
