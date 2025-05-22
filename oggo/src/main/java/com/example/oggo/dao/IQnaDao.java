package com.example.oggo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.oggo.dto.QnaDTO;

@Mapper
public interface IQnaDao {
	List<QnaDTO> selectQna();
}
