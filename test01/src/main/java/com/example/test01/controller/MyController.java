package com.example.test01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test01.dto.UserDTO;

@Controller//Bean으로 등록함(자바클래스)스프링에게 위임, 요청과 응답을 처리하는 클래스로 변신함
public class MyController {
	@GetMapping("/")//중요한거 1
	public String root() {
		
		return "index";//중요한거 2
	}
	
	@GetMapping("/p1")//중요한거 1
	//자동으로 바인딩되는 객체를 커맨드객체라고 한다
	public String p1(UserDTO userDTO, Model model) {//쿼리스트링으로 날아오는 파라미터 처리, 파라미터를 잘못받으면 400에러가 발생함
		//모델은 뷰에 전달할 데이터가 있을때 사용함
		
		//뷰에 데이터 전달
		//model.addAttribute("vname", name);
		//model.addAttribute("vage", age);
		//하나로 통합해서 보내기
		
		//user.setName(name);
		//user.setAge(age);
		
		//model.addAttribute("user",user);
		
		return "p1";//중요한거 2
	}
	@GetMapping("/p2/{name}/{age}")//경로에 데이터를 저장하는 방식
	public String p2(Model model,@PathVariable("name")String name,//스프링으로 부터 Model을 주입받는다.
					@PathVariable("age")int age) {
		UserDTO user = new UserDTO();
		user.setName(name);
		user.setAge(age);
		model.addAttribute("user",user);//이름표를 달아야한다!!!! 가장 중요 자주 까먹음 
		return"p2";
	}
	
	@GetMapping("/reg")
	public  String reg(UserDTO user,Model model) {
		System.out.println(user);
		model.addAttribute("user",user);
		return "succsess";
		
	}
	
	@GetMapping("/getdata")
	public @ResponseBody String getdata(@RequestParam("n")int n) {
		String[] strs = {"aaa","bbb","ccc"};
		
		return strs[n];
		
	}
	
	@GetMapping("/getdata2")
	public @ResponseBody UserDTO getdata2(@RequestParam("n")int n) {
		UserDTO user = new UserDTO();
		user.setName("홍길동");
		user.setAge(33);
		UserDTO user2 = new UserDTO();
		user2.setName("홍길순");
		user2.setAge(22);
		String[] strs = {"aaa","bbb","ccc"};
		
		return user2;
		
	}
	
	
}
