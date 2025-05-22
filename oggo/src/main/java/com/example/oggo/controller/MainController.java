package com.example.oggo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oggo.dao.IQnaDao;
import com.example.oggo.dao.IReservationDao;
import com.example.oggo.dao.IUserDao;
import com.example.oggo.dto.QnaDTO;
import com.example.oggo.dto.ReservationDTO;
import com.example.oggo.dto.UserDTO;

@Controller
public class MainController {
	@Autowired
	private IQnaDao qnadao;
	@Autowired
	private IUserDao userdao;
	@Autowired
	private IReservationDao reservationdao;
	
	@GetMapping("/")
	public String root() {
		
		return "index";
	}
	@GetMapping("/management")
	public String mamgementPage(Model model) {
		List<QnaDTO>qnaList = qnadao.selectQna();
		//System.out.println(qnaList);
		model.addAttribute("list", qnaList);
		return "/admin/management";
	}
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
}
