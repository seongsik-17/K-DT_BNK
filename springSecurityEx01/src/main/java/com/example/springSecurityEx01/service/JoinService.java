package com.example.springSecurityEx01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springSecurityEx01.dto.UserDTO;
import com.example.springSecurityEx01.entity.User;
import com.example.springSecurityEx01.repository.UserRepository;
@Service
public class JoinService {
	@Autowired
	private BCryptPasswordEncoder bCtyptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User regist(UserDTO userdto) {
		//0. 서비스 단에서 컨트롤러에서 전달한 파라미터를 받음.
		//1. 파라미터 중 패스워드를 암호화 처리
		String newPw = bCtyptPasswordEncoder.encode(userdto.getPassword());
		//2. DTO -> Entity
		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setName(userdto.getName());
		user.setPassword(newPw);
		//3. Roll 정보 저장
		//username이 admin이면 'ROLE_ADMIN'
		//아니면 'ROLE_MEMBER'
		if(userdto.getName().equals("admin")) {
			user.setRole("ROLE_ADMIN");
		}else {
			user.setRole("ROLE_MEMBER");
		}
		return userRepository.save(user);
		
	}
	
	
}
