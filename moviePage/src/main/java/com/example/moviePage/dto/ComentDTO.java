package com.example.moviePage.dto;

import lombok.Data;

@Data
public class ComentDTO {
	private int comentId;
	private String id;
	private int movie_code;
	private String coment;
	private String regDate;
}
