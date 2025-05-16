package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.dao.IContentDao;
import com.example.board.dao.IMemberDao;
import com.example.board.dto.ContentDTO;
import com.example.board.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	int start = 1;
	int end = 10;
	private IMemberDao memberdao;
	private IContentDao contentdao;

	@Autowired
	public MainController(IMemberDao dao, IContentDao cdao) {
		memberdao = dao;
		contentdao = cdao;
	}

	@GetMapping("/")
	public String root() {
		return "login";
	}

	@PostMapping("/login")
	public String login(MemberDTO member, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO m = memberdao.getMember(member.getId());
		if (m != null && m.getPw().equals(member.getPw())) {
			session.setAttribute("id", member.getId());
			return "index";
		} else {
			session.setAttribute("msg", "로그인 실패!");
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

	// -------------------------------------------------------------------------
	// 게시판 Controller
	@GetMapping("/listContent")
	public String listContent(Model model, @RequestParam("startNum") int startNum, @RequestParam("endNum") int endNum) {
		int totalPage = contentdao.getPageNum();
		int endofPage = 0;
		
		if (totalPage % 10 != 0) {
			endofPage = (totalPage / 10) + 1;
		} else {
			endofPage = totalPage / 10;
		}
		
		List<ContentDTO> list = contentdao.getContentList(startNum, endNum);
		model.addAttribute("list", list);
		model.addAttribute("toatlPage", totalPage);
		model.addAttribute("endofPage",endofPage);

		return "viewBoard";
	}

	@GetMapping("/detail")
	public @ResponseBody ContentDTO detail(@RequestParam("id") String id) {
		ContentDTO content = contentdao.getContent(id);
		System.out.println(content);
		return content;
	}
}
