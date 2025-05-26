package com.example.oggo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import jakarta.servlet.http.HttpServletResponse;

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
		System.out.println(list);
		return list;
	};

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
		System.out.println(getUser);
		return getUser;
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

	@GetMapping("/monthlySalesPdf")
	public void generateMonthlySalesPdf(HttpServletResponse response) throws IOException {
		// 1. 파일 설정
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"monthly_sales.pdf\"");

		PdfWriter writer = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);

		// 2. 데이터 가져오기
		List<List<Object>> data = getMonthlySalesDataset(); // 위에 있던 메서드 재사용

		// 3. 제목
		document.add(new Paragraph("월별 상품 매출 보고서").setBold().setFontSize(16).setMarginBottom(10));

		// 4. 테이블 생성
		int columnCount = data.get(0).size();
		Table table = new Table(UnitValue.createPercentArray(columnCount)).useAllAvailableWidth();

		// 헤더 행 생성
		for (Object header : data.get(0)) {
		    Cell headerCell = new Cell()
		        .add(new Paragraph(header.toString()).setBold())
		        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
		        .setTextAlignment(TextAlignment.CENTER);

		    table.addHeaderCell(headerCell);
		}


		// 6. 데이터 행
		for (int i = 1; i < data.size(); i++) {
			for (Object cell : data.get(i)) {
				
				table.addCell(cell.toString());
			}
		}

		document.add(table);
		document.close();
	}

}
