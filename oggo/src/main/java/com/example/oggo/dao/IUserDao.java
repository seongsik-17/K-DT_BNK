package com.example.oggo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.oggo.dto.UserDTO;

@Mapper
public interface IUserDao {
	List<UserDTO> selectUserList();
	UserDTO serchUserInfo(@Param("user")UserDTO user);
}
