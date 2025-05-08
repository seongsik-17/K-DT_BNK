package com.example.openAPI.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.openAPI.api.ApiExplorer;
import com.example.openAPI.api.ApiExplorer2;

@Controller
public class MainController {
	@RequestMapping("/")
	public String root() {
		System.out.println("root.....");
		return "index";
		
	}
	@GetMapping("/getAll")
	public @ResponseBody String getAll() {
		ApiExplorer ae = new ApiExplorer();
		String content = "로딩실패...";
		try {
			content = ae.getJson();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("getAll.....");
		//System.out.println(content);
		return content;
	}
	
	@GetMapping("/getAll2")
	public @ResponseBody String getAll2() {
		ApiExplorer2 ae = new ApiExplorer2();
		String content = "로딩실패...";
		try {
			content = ae.getJson();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("getAll2.....");
		//System.out.println(content);
		return content;
	}
}
