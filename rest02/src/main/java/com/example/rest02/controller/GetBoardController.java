package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;
//http://localhost:8090/api/board-get/info
@RestController
@RequestMapping("/api/board-get")
public class GetBoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/{bno}")
	public BoardEntity getBoardByBno(@PathVariable("bno")Integer bno) {
		BoardEntity result = boardService.getBoardByBno(bno);
		
		return result;
		
		
	}
	
}
