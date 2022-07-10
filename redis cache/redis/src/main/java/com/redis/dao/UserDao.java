package com.redis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redis.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
