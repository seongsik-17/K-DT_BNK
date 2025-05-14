package com.example.moviePage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.moviePage.dto.MemberDTO;

@Mapper
public interface IMemberDao {
	MemberDTO selectOne(@Param("id")String id);
	void insertMember(@Param("m")MemberDTO m);
}
