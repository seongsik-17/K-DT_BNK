package com.example.board.dto;

import lombok.Data;

@Data
public class ContentDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
}
