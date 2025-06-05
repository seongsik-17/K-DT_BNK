package com.example.rest02.util;

import com.example.rest02.dto.BoardDTO;
import com.example.rest02.entity.BoardEntity;

public class ConvertEntity_DTO {
	
	public BoardEntity dtoToEntity(BoardDTO board) {
		
		BoardEntity entity = new BoardEntity();
		
		entity.setBno(board.getBno());
		entity.setTitle(board.getTitle());
		entity.setContent(board.getContent());
		entity.setWriter(board.getWriter());
		
		return entity;
	}
	public BoardDTO entityToDTO(BoardEntity entity) {
		
		BoardDTO board = new BoardDTO();
		
		board.setBno(entity.getBno());
		board.setTitle(entity.getTitle());
		board.setContent(entity.getContent());
		board.setWriter(entity.getWriter());
		
		return board;
	}
	
	
}
