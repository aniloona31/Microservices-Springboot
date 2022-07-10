package com.caching.caching.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caching.caching.Dao.ProductDao;
import com.caching.caching.Entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productRepository;

	@Override
	public Product getProductById(int productId) {
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productRepository.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productRepository.getAllProducts();
	}

	@Override
	public Product saveProductDetails(Product product) {
		productRepository.addProduct(product);
		return product;
	}
	
	
}
