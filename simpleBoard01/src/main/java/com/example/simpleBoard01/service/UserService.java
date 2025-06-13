package com.example.simpleBoard01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleBoard01.dto.UserDTO;
import com.example.simpleBoard01.entity.User;
import com.example.simpleBoard01.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User convertDTOtoEntity(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		
		return user;
	}
	//유저데이터 삽입
	public void insertUserData(UserDTO userDTO) {
		try {
			userRepository.save(convertDTOtoEntity(userDTO));
			System.out.println("데이터가 성공적으로 삽입되었습니다");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
	
	
	
}
