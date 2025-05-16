package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board.dto.ContentDTO;
import com.example.board.dto.MemberDTO;



@Mapper	
public interface IMemberDao {
	
	MemberDTO getMember(@Param("id")String id);
	List<MemberDTO> getlist();
	void insert(@Param("m")MemberDTO member);
}

