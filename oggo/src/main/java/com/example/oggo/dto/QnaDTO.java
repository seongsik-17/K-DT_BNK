package com.example.oggo.dto;

import lombok.Data;

@Data
public class QnaDTO {
	private int qna_id;
	private String user_id;
	private String title;
	private String content;
	private String answer;
	private String is_answered;
	private int views;
	private String created_at;
	private String answered_at;
}
