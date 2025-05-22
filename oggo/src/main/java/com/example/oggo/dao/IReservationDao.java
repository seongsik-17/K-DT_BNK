package com.example.oggo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.oggo.dto.ReservationDTO;

@Mapper
public interface IReservationDao {
	List<ReservationDTO>selectReservation();
}
