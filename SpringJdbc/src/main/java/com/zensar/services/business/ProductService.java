package com.zensar.services.business;

import java.util.List;


import com.zensar.entities.Product;

/*
 * Author: Nishita Khandelwal
 * Creation Date: 29th July 2019 5.55PM
 * Modified Date: 29th July 2019 9.50AM
 * Version: 3.0
 * Copyright: Zensar Technologies. Alll rights reserved. 
 * Description: Represents product services which can be accessed by presentation layer.
 * It encapsulates business logic of product entity.
 * */

public interface ProductService {
	
	
	void create(Product product);
	void edit(Product product);
	void remove(Product product);
	Product findProductById(int productId);
	List<Product> findAllProducts();
	

}
