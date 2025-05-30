package com.example.springSecurityEx01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springSecurityEx01.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	User findByUsername(String username);
}	
