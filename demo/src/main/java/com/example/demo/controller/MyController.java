package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.Member;

@Controller
public class MyController {
	List<Member>list;
	@RequestMapping("/")
	public @ResponseBody String root() {
		System.out.println("root..............");
		return "Springboot Start!!";// JSP파일 이름 자리
		// return의 용도
		// 1.페이지 이름(View를 지정)
		// 2.데이터를 보내는 용, @ResponseBody를 붙이면 데이터를 전달한다...
	}

	@GetMapping("/test")
	public String test() {
		System.out.println("test................");
		return "test";
	}

	@GetMapping("/p2")
	public String p1(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name,
			Model model) {
		System.out.println("p1................");
		List<Member>list = new ArrayList<>();
		Member m = new Member();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		
		list.add(m);

		model.addAttribute("list",list);
		return "p1";
	}
	@PostMapping("/p1")
	public String p2(Member m,Model model) {
		
		list.add(m);
		model.addAttribute("list",list);
		for(Member m1:list) {
			System.out.println(m1);
		}
		return "p1";
		
	}
	@GetMapping("/p3/{id}/{pw}")
	public String p3(@PathVariable("id")String id, @PathVariable("pw")String pw,Model model) {
		
		System.out.println("p3........."+id+","+pw);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		
		
		return "p3";
	}
}
