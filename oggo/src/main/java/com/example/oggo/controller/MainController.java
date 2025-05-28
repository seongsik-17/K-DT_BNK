package com.example.oggo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		List<QnaDTO> qnaList = qnadao.selectQna();
		// System.out.println(qnaList);
		model.addAttribute("qnaList", qnaList);
		// 통계 데이터 전송

		return "/admin/management";
	}

	@GetMapping("/getQnAList")
	public @ResponseBody List<QnaDTO> getQnaList() {
		List<QnaDTO> list = qnadao.selectQna();
		//System.out.println(list);
		return list;
	};
	
	@GetMapping("updateQnA_Ans")
	public @ResponseBody String insertQnA_Ans(QnaDTO qna_ans){
		int result = qnadao.updateQnA_Ans(qna_ans);
		if(result == 1) {
			return "답변 성공";
		}return "등록 실패";
	}
	@GetMapping("/getUserList")
	public @ResponseBody List<UserDTO> userList() {
		List<UserDTO> userList = userdao.selectUserList();
		// System.out.println(userList);
		return userList;
	}

	@GetMapping("/getUser")
	public @ResponseBody UserDTO userByName(UserDTO user) {
		System.out.println(user);
		UserDTO getUser = userdao.serchUserInfo(user);
		//System.out.println(getUser);
		return getUser;
	}
	@GetMapping("/getUserById")
	public @ResponseBody UserDTO userById(UserDTO user) {
		System.out.println(user);
		UserDTO getUser = userdao.selectUserById(user);
		//System.out.println(getUser);
		return getUser;
	}
	@PostMapping("/userInfoUpdate")
	public @ResponseBody String userInfoUpdate(UserDTO getuser) {
		// 비밀번호 암호화
				// 1. salt 생성
				String salt = mySalt.getSalt();
				// 2. SHA-256 해싱(암호화)
				String encodePassword = myEncode.getEncodePw(getuser.getPassword(), salt);
						
				UserDTO user = new UserDTO();
				// join_date랑 마지막 로그인 시간, role은 dao에서 입력해주기
				user.setUser_id(getuser.getUser_id());
				user.setPassword(encodePassword);
				user.setSalt(salt);
				user.setName(getuser.getName());
				user.setEmail(getuser.getEmail());
				user.setPhone(getuser.getPhone());
				user.setAddress(getuser.getAddress());
				user.setBirth_date(getuser.getBirth_date());
				// 회원가입 정보 저장
				int result = userdao.userInfoUpdate(user);
				if(result == 1) {
					return "회원정보 수정 성공";
				}
		return "회원정보 수정 실패!";
	}
	@GetMapping("/getAllReservation")
	public @ResponseBody List<ReservationDTO> allReservations(){
		List<ReservationDTO> list = reservationdao.selectAllReservation();
		return list;
	}
	@GetMapping("/getReservations")
	public @ResponseBody List<ReservationDTO> Reservations() {
		List<ReservationDTO> reservationList = reservationdao.selectReservation();
		// System.out.println(reservationList);
		return reservationList;
	}

	@GetMapping("/getSalse")
	public @ResponseBody List<TotalSalseDTO> getSalse() {
		List<TotalSalseDTO> totalSalse = istasticsdao.totalSalse();
		// System.out.println(totalSalse);
		return totalSalse;
	}

	@GetMapping("/getMonthlySalesDataset")
	public @ResponseBody List<List<Object>> getMonthlySalesDataset() {
		List<MonthlyStatisticsDTO> stats = istasticsdao.selectMonthlyProductSales();

		Map<String, Double[]> productMonthlyMap = new LinkedHashMap<>();
		for (MonthlyStatisticsDTO dto : stats) {
			String title = dto.getTitle();
			int monthIdx = Integer.parseInt(dto.getMonth()) - 1;

			productMonthlyMap.putIfAbsent(title, new Double[12]);
			productMonthlyMap.get(title)[monthIdx] = (double) dto.getTotal_sales();
		}

		//차트에ㅐ 적용 가능한 형태로 데이터 구성
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

	@GetMapping("/forbiddenWords")
	public @ResponseBody List<QnaDTO> forbiddenWords() {
		List<QnaDTO> forbiddenWords = qnadao.selectForbiddenWords();
		System.out.println(forbiddenWords);
		return forbiddenWords;
	}

	@PostMapping("/updateResStatus")
	public @ResponseBody String updateResStatus(@RequestParam("res_id") int res_id) {
		reservationdao.updateResStatus(res_id);
		return "예약 ID " + res_id + "의 결제 상태가 변경되었습니다.";

	}
	
	@GetMapping("/monthlyCount")
	public @ResponseBody List<MonthlyStatisticsDTO> monthlyCount(@RequestParam("month")String date) {
		String year = date.substring(0, 4);   // "2025"
	    String month = date.substring(5, 7);  // "05"
	    System.out.println(date);
	    List<MonthlyStatisticsDTO> list = istasticsdao.selectMonthlySalesByYearAndMonth(year, month);
	    return list;
		
	}
	// 솔트값 생성(랜덤)
		public class mySalt{
			public static String getSalt() {
				Random random = new Random();
				String salt = "";
				for(int i=0; i<16; i++) {
					int ascii = random.nextInt(94) + 33; // ascii 코드에서 랜덤값 (공백이랑 이상한 거 제외)
					salt += (char)ascii;
				}			
				return salt;
			}
		}
		
		// 입력한 pw + salt를 암호화하기
		public class myEncode{
			public static String getEncodePw(String password, String salt) {
				
				// 사용자가 입력한 pw랑 랜덤 salt값을 합친 문장
				String input = password + salt;
				int hash = 0;
				// 문자열마다 가중치 연산해서 더하기
		        for (int i = 0; i < input.length(); i++) {
		            char c = input.charAt(i);
		            hash += (c * (i + 1));  // 가중치 곱해서 더함
		        }
		        // 16진수 문자열로 반환
		        return Integer.toHexString(hash);
			}
		}


}
