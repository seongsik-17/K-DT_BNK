package com.example.rest02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.rest02.dto.BoardDTO;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.repository.BoardRepository;
import com.example.rest02.util.ConvertEntity_DTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	//게시글 등록업무(기능=함수) - registBoard : 준비 -> 게시글, 결과 -?? 
	public BoardEntity registBoard(BoardDTO board){
		//DTO를 Entity로 변환하는 작업을 진행해야한다.
		BoardEntity entity = new BoardEntity();
		
		entity.setTitle(board.getTitle());
		entity.setContent(board.getContent());
		entity.setWriter(board.getWriter());
		
		
		BoardEntity result = boardRepository.save(entity);//엔티티가 둘어가야함
		
		return result;
	}
	
	public BoardEntity getBoardByBno(@PathVariable("bno")Integer bno) {
		//Optional<BoardEntity> result = boardRepository.findById(bno);
		BoardEntity boardEntity = boardRepository.findByBno(bno);
		return boardEntity;
		
	}
	
	//게시글 수정 업무 - updateBoard : 준비 - 수정된 게시글, 결과 - ? 
	public BoardEntity updateboard(BoardDTO board){
		ConvertEntity_DTO convert = new ConvertEntity_DTO();
		BoardEntity entity = new BoardEntity();
		entity = convert.dtoToEntity(board);
		//DTO변환 작업
	
		
		BoardEntity result = boardRepository.save(entity);
		
		return result;
	}
	
	//게시글 삭제 업무 - deleteBoard: 준비 - bno 결과: ?
	public void deleteBoard(Integer bno) {
		boardRepository.deleteById(bno);
	}
	

}
