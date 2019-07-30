package com.zensar.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.daos.ProductDao;
import com.zensar.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;

	public void create(Product product) {
		
		dao.insert(product);

	}

	public void edit(Product product) {
		
		Product dbProduct = findProductById(product.getProductId());
		if(dbProduct!=null) {
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setPrice(product.getPrice());
			dao.update(dbProduct);
		}else
			System.out.println("Sorry! product does not exist");

	}

	public void remove(Product product) {
		
		Product dbProduct = findProductById(product.getProductId());
		if(dbProduct!=null) {
			dao.delete(dbProduct);
		}else
			System.out.println("Sorry! product does not exist");

	}

	public Product findProductById(int productId) {
		
		return dao.getById(productId);
	}

	public List<Product> findAllProducts() {
		
		return dao.getAll();
	}

}
