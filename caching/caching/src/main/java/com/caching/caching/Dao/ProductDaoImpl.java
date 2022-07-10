package com.caching.caching.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.caching.caching.Entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	HashMap<Integer,Product> products = new HashMap<>();
	
	@PostConstruct
	private void fillProducts() {
		products.put(1, new Product(1, "Chocolate", 65));
		products.put(2, new Product(2, "cake", 200));
		products.put(3, new Product(3, "almonds", 700));
		products.put(4, new Product(4, "peanut butter", 200));
		products.put(5, new Product(5, "bat", 1200));
		products.put(6, new Product(6, "shorts", 600));
	}

	@Override
	public Product getProductById(int id) {
		return products.get(id);
	}

	@Override
	public List<Product> getAllProducts() {
		Collection<Product> collection = products.values();
		Iterator<Product> iterator = collection.iterator();
		List<Product> productList = new ArrayList<Product>();
		
		while(iterator.hasNext()) {
			productList.add(iterator.next());
		}
		
		return productList;
	}

	@Override
	public Product addProduct(Product product) {
		products.put(product.getId(), product);
		return product;
	}
	
	

}
