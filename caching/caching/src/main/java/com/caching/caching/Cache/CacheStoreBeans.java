package com.caching.caching.Cache;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caching.caching.Entity.Employee;
import com.caching.caching.Entity.Product;

@Configuration
public class CacheStoreBeans {
	
	@Bean
	public CacheStore<Employee> employeeCache(){
		return new CacheStore<Employee>(60, TimeUnit.SECONDS);
	};
	
	@Bean
	public CacheStore<Product> productCache(){
		return new CacheStore<Product>(60,TimeUnit.SECONDS);
	}
}
