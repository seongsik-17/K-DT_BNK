package com.example.oggo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oggo.dao.IQnaDao;
import com.example.oggo.dao.IReservationDao;
import com.example.oggo.dao.IStasticsDao;
import com.example.oggo.dao.IUserDao;
import com.example.oggo.dto.MonthlyStatisticsDTO;
import com.example.oggo.dto.QnaDTO;
import com.example.oggo.dto.ReservationDTO;
import com.example.oggo.dto.TotalSalseDTO;
import com.example.oggo.dto.UserDTO;

@Controller
public class MainController {
	@Autowired
	private IQnaDao qnadao;
	@Autowired
	private IUserDao userdao;
	@Autowired
	private IReservationDao reservationdao;
	@Autowired
	private IStasticsDao istasticsdao;
	
	
	@GetMapping("/")
	public String root() {
		
		return "index";
	}
	@GetMapping("/management")
	public String mamgementPage(Model model) {
		List<QnaDTO>qnaList = qnadao.selectQna();
		//System.out.println(qnaList);
		model.addAttribute("qnaList", qnaList);
		//통계 데이터 전송
		
		return "/admin/management";
	}
	@GetMapping("/getQnAList")
	public @ResponseBody List<QnaDTO>getQnaList(){
		List<QnaDTO> list = qnadao.selectQna();
		System.out.println(list);
		return list;
	};
	
	
	@GetMapping("/getUserList")
	public @ResponseBody List<UserDTO> userList() {
		List<UserDTO>userList = userdao.selectUserList();
		//System.out.println(userList);
		return userList;
	}
	@GetMapping("/getUser")
	public @ResponseBody UserDTO userByName(UserDTO user) {
		System.out.println(user);
		UserDTO getUser = userdao.serchUserInfo(user);
		System.out.println(getUser);
		return getUser;
	}
	
	@GetMapping("/getReservations")
	public @ResponseBody List<ReservationDTO> Reservations() {
		List<ReservationDTO>reservationList = reservationdao.selectReservation();
		//System.out.println(reservationList);
		return reservationList;
	}
	@GetMapping("/getSalse")
	public @ResponseBody List<TotalSalseDTO> getSalse(){
		List<TotalSalseDTO>totalSalse = istasticsdao.totalSalse();
		//System.out.println(totalSalse);
		return totalSalse;
	}
	@GetMapping("/getMonthlySalesDataset")
	@ResponseBody
	public List<List<Object>> getMonthlySalesDataset() {
	    List<MonthlyStatisticsDTO> stats = istasticsdao.selectMonthlyProductSales(); 
	    // dto: title, month (1~12), total_sales

	    // Map<상품명, Double[12]> 생성
	    Map<String, Double[]> productMonthlyMap = new LinkedHashMap<>();
	    for (MonthlyStatisticsDTO dto : stats) {
	        String title = dto.getTitle();
	        int monthIdx = Integer.parseInt(dto.getMonth()) - 1;

	        productMonthlyMap.putIfAbsent(title, new Double[12]);
	        productMonthlyMap.get(title)[monthIdx] = (double) dto.getTotal_sales();
	    }

	    // dataset.source 형태로 변환
	    List<List<Object>> source = new ArrayList<>();
	    source.add(Arrays.asList("product", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"));

	    for (Map.Entry<String, Double[]> entry : productMonthlyMap.entrySet()) {
	        List<Object> row = new ArrayList<>();
	        row.add(entry.getKey());
	        for (int i = 0; i < 12; i++) {
	            row.add(entry.getValue()[i] != null ? entry.getValue()[i] : 0.0);
	        }
	        source.add(row);
	    }

	    return source;
	}
	
	
}
