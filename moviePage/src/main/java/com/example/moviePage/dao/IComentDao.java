package com.example.moviePage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.moviePage.dto.ComentDTO;

@Mapper
public interface IComentDao {
	List<ComentDTO> selectAll(@Param("movie_code")int m_code);
	void insert(@Param("c")ComentDTO coment);
	int selectEndNum();
	void delete(@Param("comentId")String id);
}
