package com.caching.caching.Cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

//Generics
public class CacheStore<T> {
	//i dont need to inject it using autowired because i am using constructor injection by initializing it,
	private Cache<Integer,T> cache;
	
	/*
	 * define the constructor to build the cache
	 * 
	 * what things i should define in cache??
	 * TTL (time to live)
	 * 
	 * guava cache uses builder design pattern
	 * concurrencyLevel tells how many parallel requests can come.
	 */
	
	public CacheStore(int ttl,TimeUnit timeUnit) {
		cache = CacheBuilder.newBuilder().expireAfterWrite(ttl, timeUnit).concurrencyLevel(Runtime.getRuntime().availableProcessors()).build();
	}
	
	
	public T get(int key) {
		return cache.getIfPresent(key);
	}
	
	public void add(int key,T value) {
		if(key >= 0 && value != null) {
			cache.put(key, value);
		}
	}
}
