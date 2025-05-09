package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.dao.IMemberDao;
import com.example.board.dto.ContentDTO;
import com.example.board.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	private IMemberDao memberdao;
	@Autowired
	public MainController(IMemberDao dao) {
		memberdao = dao;
	}
	@GetMapping("/")
	public String root() {
		return "login";
	}
	@PostMapping("/login")
	public  String login(MemberDTO member,
						HttpServletRequest request) {
		HttpSession session= request.getSession();
		MemberDTO m = memberdao.getMember(member.getId());
		if(m != null && m.getPw().equals(member.getPw())) {
			session.setAttribute("id",member.getId());
			return "index";
		}else {
			session.setAttribute("msg","로그인 실패!");
			return "login";
		}
		
	}
	@GetMapping("/regist_m")
	public String regist_m() {
		return "registMember";
	}
	@PostMapping("/insert")
	public String insert(MemberDTO member) {
		memberdao.insert(member);
		return "login";
	}
	@GetMapping("/listContent")
	public String listContent(Model model) {
		List<ContentDTO>list = memberdao.getContentList();
		model.addAttribute("list",list);
		
		return "viewBoard";
	}
	@GetMapping("/detail")
	public @ResponseBody ContentDTO detail(@RequestParam("id")String id) {
		ContentDTO content = memberdao.getContent(id);
		System.out.println(content);
		return content;
	}
}
