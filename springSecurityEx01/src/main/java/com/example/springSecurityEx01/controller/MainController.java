package com.example.springSecurityEx01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springSecurityEx01.dto.UserDTO;
import com.example.springSecurityEx01.entity.User;
import com.example.springSecurityEx01.service.JoinService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller

public class MainController {	
	@Autowired
	JoinService joinService;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/regMember")
	public String regMemberForm() {
		return "regForm";
	}
	
	@PostMapping("/regist")
	public @ResponseBody String regMember(UserDTO userDto) {
		System.out.println(userDto);
		log.info("UserDTO: "+userDto);
		//파라미터 서비스에 전달 ---> 서비스에서 회원가입 처리를 진행
		User result = joinService.regist(userDto);
		if(result == null) {
			return "회원가입 실패";
		}
		return "회원가입 완료";
		
	}
	@GetMapping("/loginProc")
	public String loginProc() {
		return "loginProc";
	}
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/fail")
	public String fail() {
		return "fail";
	}
}
