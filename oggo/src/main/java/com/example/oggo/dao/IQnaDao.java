package com.example.oggo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.oggo.dto.QnaDTO;

@Mapper
public interface IQnaDao {
	List<QnaDTO> selectQna();//답변하지 않은 QnA리스트 호
	List<QnaDTO> selectForbiddenWords();//욕설이 포함된 Qna 리스트
	int updateQnA_Ans(@Param("qna")QnaDTO qna );
}
