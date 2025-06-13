package com.example.simpleBoard01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.simpleBoard01.dto.UserDTO;
import com.example.simpleBoard01.entity.User;
import com.example.simpleBoard01.service.UserService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/registForm")
	public String registForm() {
		return "/registForm";
	}

	@PostMapping("/regist")
	public String registUser(UserDTO userDTO) {
		userService.insertUserData(userDTO);
		return "redirect:/";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {

        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "loginForm";
        }
    }

}
