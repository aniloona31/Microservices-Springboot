package com.caching.caching.Dao;

import java.util.List;

import com.caching.caching.Entity.Product;

public interface ProductDao {
	
	Product getProductById(int id);
	List<Product> getAllProducts();
	Product addProduct(Product product);
}
