package com.caching.caching.Service;

import java.util.List;


import com.caching.caching.Entity.Product;

public interface ProductService {
    Product getProductById(int productId);
    List<Product> getAllProducts();
    Product saveProductDetails(Product product);
}
