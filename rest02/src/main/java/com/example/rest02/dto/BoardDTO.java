package com.example.rest02.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDTO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;//등록시간
	private LocalDateTime mdDate;//수정시간
}
