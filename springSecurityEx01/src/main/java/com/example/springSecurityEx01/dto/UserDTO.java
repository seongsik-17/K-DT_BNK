package com.example.springSecurityEx01.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private String name;
	private String role;
}
