package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberDao;


@WebServlet("/rege")
public class RegistMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		//2. 값 설정하기
		String grade = "일반";
		//3. 데이터베이스에 넣기
		MemberDao dao = new MemberDao();
		dao.insert(id, pw, name, grade);
		Member m = dao.select(id);
		
		
		request.setAttribute("id", m.getId());
		request.setAttribute("pw", m.getPw());
		request.setAttribute("name", m.getName());
		request.setAttribute("grade", m.getGrade());
	
		
		request.getRequestDispatcher("Result.jsp").forward(request, response);
		
		
	}

}
