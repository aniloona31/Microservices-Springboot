package com.caching.caching.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.caching.caching.Cache.CacheStore;
import com.caching.caching.Entity.Employee;
import com.caching.caching.Entity.Product;
import com.caching.caching.Service.EmployeeService;
import com.caching.caching.Service.ProductService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CacheStore<Employee> employeeCache;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> searchEmployeeById(@PathVariable Integer id){
		
		/*
		 * write the caching logic here (guava cache)
		 */
		//first check in the cache
		Employee cachedEmployee = employeeCache.get(id);
		
		if(cachedEmployee != null) {
			return new ResponseEntity<Employee>(cachedEmployee, HttpStatus.OK);
		}
		
		Employee savedEmployee = employeeService.getEmployeeByID(id);
		
		employeeCache.add(id, savedEmployee);
		
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> searchProductById(@PathVariable Integer id){
		Product savedProduct = productService.getProductById(id);
		return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
	}
}
