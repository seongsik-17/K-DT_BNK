package com.example.moviePage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.moviePage.dao.IComentDao;
import com.example.moviePage.dao.IMemberDao;
import com.example.moviePage.dao.IMovieDao;
import com.example.moviePage.dao.INoticeDao;
import com.example.moviePage.dto.ComentDTO;
import com.example.moviePage.dto.MemberDTO;
import com.example.moviePage.dto.MovieDTO;
import com.example.moviePage.dto.NoticeDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	IMemberDao memberdao;
	IMovieDao moviedao;
	IComentDao comentdao;
	INoticeDao noticedao;
	
	@Autowired
	private MainController(IMemberDao mdao,IMovieDao mov,IComentDao cdao,INoticeDao ndao) {
		memberdao = mdao;
		moviedao = mov;
		comentdao = cdao;
		noticedao = ndao;
		
	}
	//-------------------------------------------
	//멤버 컨트롤
	@GetMapping("/")
	public String root(Model model) {
		List<MovieDTO> list = moviedao.selectAll();
		List<NoticeDTO> n_list = noticedao.selectAll();
		model.addAttribute("list",list);
		model.addAttribute("notice",n_list);
		return "index";
	}
	@GetMapping("/login")
	public String log() {
		return "login";
	}
	@GetMapping("/regMember")
	public String regMember() {
		return "regMember";
	}
	@GetMapping("/checkId")
	public @ResponseBody String checkId(@RequestParam("id")String id){
		MemberDTO m = memberdao.selectOne(id);
		if(m==null) {
			return "사용가능한 아이디 입니다!!";
		}
		return "이미 사용중인 아이디 입니다!!";
	}
	@PostMapping("/insertMember")
	public String insertMember(MemberDTO member) {
		memberdao.insertMember(member);
		return"login";
	}
	@PostMapping("/login")
	public String login(MemberDTO m,HttpServletRequest request,Model model) {
		MemberDTO member = memberdao.selectOne(m.getId());
		HttpSession session = request.getSession();
		List<MovieDTO>list = moviedao.selectAll();
		if(member != null && m.getPw().equals(member.getPw())) {
			session.setAttribute("member",member);
			System.out.println("세션 저장정보: "+member);
			model.addAttribute("list",list);
			System.out.println("로그인 성공!");
			return "index";
		}
		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("member");
		return "index";
	}
	//---------------------------------------------------------
	//영화보드 컨트롤러
	@GetMapping("/expectedMovie")
	public String expectedMovie(Model model) {
		List<MovieDTO> list = moviedao.selectExpectedMovie();
		
		model.addAttribute("list",list);
		return "expectedMoviePage";
	}
	@GetMapping("/endMovieList")
	public String endMoveList(Model model) {
		List<MovieDTO>list = moviedao.selectEndMovie();
		
		model.addAttribute("list",list);
		
		return "endMovieList";
	}
	@GetMapping("/insertMovie")
	public String insertM() {
		return"insertMovie";
	}
	@PostMapping("/insertMovie")
	public String insertMovie(MovieDTO mdto) {
		int lastNum = moviedao.getLastMovie_code();
		
		mdto.setMovie_code(lastNum+1);
		moviedao.insertMovie(mdto);
		
		return "index";
	}
	@GetMapping("/detail")
	public String detail(@RequestParam("movie_code")int code,Model model) {
		MovieDTO movie = moviedao.selectOne(code);
		List<ComentDTO>list = comentdao.selectAll(code);
		//System.out.println(list);
		model.addAttribute("m",movie);
		model.addAttribute("list",list);
		return "detailPage";
	}
	@PostMapping("/regComent")
	public String regComent(ComentDTO c) {
		System.out.println("id: "+ c.getId());
		System.out.println("move_code: "+c.getMovie_code());
		ComentDTO coment = new ComentDTO();
		coment.setComentId(comentdao.selectEndNum()+1);
		coment.setId(c.getId());
		coment.setMovie_code(c.getMovie_code());
		coment.setComent(c.getComent());
		comentdao.insert(coment);
		return "redirect:/detail?movie_code="+c.getMovie_code();
	}
	@GetMapping("/rmComent/{id}/{movie_code}")
	public String rmComent(@PathVariable("id")String id,@PathVariable("movie_code")int code) {
		comentdao.delete(id);
		return "redirect:/detail?movie_code="+code;
	}
	
	//--------------------------------------------------------------
	
	
}
