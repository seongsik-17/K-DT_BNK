package com.example.rest_jwt_ex01.repository;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rest_jwt_ex01.entity.User;
@SpringBootTest
class UserTest {
	
	@Autowired
	UserRepository userRepository;
	//@Test
	void test() {
		IntStream.range(0, 5).forEach(i->{
			User user = User.builder()
					.username("user"+i)
					.password("1234"+i)
					.email("user"+i+"@email.com")
					.build();
	        

	        userRepository.save(user);
	        System.out.println("저장된 회원 ID: " + user.getId());
		});
	}

}
