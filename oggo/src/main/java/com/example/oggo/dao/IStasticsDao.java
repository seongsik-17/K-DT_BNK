package com.example.oggo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.oggo.dto.MonthlyStatisticsDTO;
import com.example.oggo.dto.TotalSalseDTO;

@Mapper
public interface IStasticsDao {
	List<TotalSalseDTO> totalSalse();
	List<MonthlyStatisticsDTO> selectMonthlyProductSales();
}
