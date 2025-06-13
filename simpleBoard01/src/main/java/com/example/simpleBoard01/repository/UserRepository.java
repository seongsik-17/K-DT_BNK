package com.example.simpleBoard01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleBoard01.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	 Optional<User> findByUsername(String username);
}
