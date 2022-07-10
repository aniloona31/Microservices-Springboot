package com.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.dao.UserDao;
import com.redis.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userRepository;
	
	public User getUserDetails(Long id) throws InterruptedException {
		Thread.sleep(1000);
		
		return userRepository.findById(id).get();
	}
}
