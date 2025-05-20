package com.example.newBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.newBoard.dao.IBoardDao;
import com.example.newBoard.dto.BoardDTO;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private IBoardDao boarddao;
	@GetMapping("/")
	public String root(Model model) {
		List<BoardDTO>list = boarddao.selectAll();
		System.out.println(list);
		model.addAttribute("list",list);
		return "index";
	}
	@PostMapping("/insertContent")
	public String insertContent(@Valid BoardDTO board, BindingResult result, Model model) {
		board.setBno(boarddao.selectEndNum());
		if(result.hasErrors()) {
			if(result.getFieldError("bno") != null) {
				System.out.println(result.getFieldError("bno").getDefaultMessage());
				model.addAttribute("msg",result.getFieldError("bno").getDefaultMessage());
				return "index";
			}
			if(result.getFieldError("title") != null) {
				System.out.println(result.getFieldError("title").getDefaultMessage());
				model.addAttribute("msg",result.getFieldError("title").getDefaultMessage());
				return "index";
			}
		}
		boarddao.insertContent(board);
		return "redirect:/";
	}
}
