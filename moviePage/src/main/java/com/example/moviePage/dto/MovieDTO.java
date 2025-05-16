package com.example.moviePage.dto;

import lombok.Data;

@Data
public class MovieDTO {
	private int movie_code;
	private String title;
	private String season_start;
	private String season_end;
	private int age_limit;
	private String adment;
	private String plot;
	private int status;
	
}
