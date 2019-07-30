package com.zensar.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/*
 * Author: Nishita Khandelwal
 * Creation Date: 29th July 2019 3.30PM
 * Modified Date: 29th July 2019 3.30pM
 * Version: 3.0
 * Copyright: Zensar Technologies. All rights reserved. 
 * Description: Represents data access object class
 * which implements DAO interface.
 * it contains CRUD operation method for an entity product.
 * 
 * */


import com.zensar.entities.Product;

@Repository

public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jt;

	public void insert(Product product) {
		
		String sql = "insert into product values(?,?,?,?)";
		jt.update(sql, product.getProductId(),product.getName(),product.getBrand(),product.getPrice());
		System.out.println("Product is inserted");

	}

	public void update(Product product) {
		String sql = "update product set name=?,brand=?,price=?" + "where id=?";
		jt.update(sql,product.getName(),product.getBrand(),product.getPrice(),product.getProductId());
		System.out.println("Product updated");
		

	}

	public void delete(Product product) {
		String sql = "delete from product" + " where id=?";
		jt.update(sql,product.getProductId());
		System.out.println("Product is deleted");
		
	}

	public Product getById(int ProductId) {
		String sql = "select * from product" + " where id=?";
		Product dbProduct = jt.query(sql, new Object[] {ProductId}, new ResultSetExtractor<Product>() {

			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt(1));
					product.setName(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					
					return product;
					
				}
				else
				return null;
			}
		});
		
		return dbProduct;
	}

	public List<Product> getAll() {
		String sql = "select * from product";
		
		List<Product> productList = jt.query(sql,new ResultSetExtractor<List<Product>>() {

			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> pList = new ArrayList<Product>();
				
				while(rs.next()) {
					
					Product p = new Product();
					p.setProductId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setBrand(rs.getString(3));
					p.setPrice(rs.getFloat(4));
					pList.add(p);
				}
				
				
				
				
				return pList;
			}
		});
		
		return productList;
	}

}
