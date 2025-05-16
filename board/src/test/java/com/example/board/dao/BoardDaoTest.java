package com.example.board.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.dto.ContentDTO;
@SpringBootTest//설정값들이 넘어옴
class BoardDaoTest {
	
	@Autowired
	IContentDao condao;
	
	@Test//이 클래스 내에서 메인으로 작동함 얘가 있어야 테스트를 수행한다...!
	void testInsert() {
		for(int i = 0; i < 100; i++) {
			ContentDTO cd = new ContentDTO();
			cd.setTitle("Title");
			cd.setContent("content");
			cd.setWriter("writer");
			cd.setRegdate("2025-05-12");
			System.out.println(cd);
			condao.insert(cd);
			
		}
	}

}
