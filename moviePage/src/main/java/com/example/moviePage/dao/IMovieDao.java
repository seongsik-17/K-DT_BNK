package com.example.moviePage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.moviePage.dto.MovieDTO;

@Mapper
public interface IMovieDao {
	List<MovieDTO>selectAll();
	MovieDTO selectOne(@Param("movie_code")int code);
	void insertMovie(@Param("movie")MovieDTO m);
	int getLastMovie_code();
	//종료된 영화
	List<MovieDTO>selectEndMovie();
	//개봉할 영화
	List<MovieDTO>selectExpectedMovie();
}
