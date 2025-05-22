package com.example.newBoard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardDTO {
	
	private int bno;
	@NotBlank(message="제목은 반드시 입력해야합니다!!")
	private String title;
	private String content;
	private String writer;
	private String regdate;
}
