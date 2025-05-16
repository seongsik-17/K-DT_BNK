package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board.dto.ContentDTO;

@Mapper
public interface IContentDao {
	ContentDTO getContent(@Param("id")String id);
	List<ContentDTO>getContentList(@Param("start")int st,@Param("end")int end);
	void insert(@Param("b")ContentDTO board);
	int getPageNum();
}
