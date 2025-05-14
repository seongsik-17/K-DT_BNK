package com.example.moviePage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.moviePage.dto.NoticeDTO;

@Mapper
public interface INoticeDao {
	
	List<NoticeDTO> selectAll();
	void remove(@Param("id")String id);
	void insert(@Param("n")NoticeDTO n);
}
