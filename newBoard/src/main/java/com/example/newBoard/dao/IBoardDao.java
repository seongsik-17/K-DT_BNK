package com.example.newBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.newBoard.dto.BoardDTO;

@Mapper
public interface IBoardDao {
	 List<BoardDTO> selectAll();
	 void insertContent(@Param("b")BoardDTO b);
	 int selectEndNum();
}
