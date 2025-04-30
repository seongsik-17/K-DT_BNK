package login;

import java.io.IOException;

import VO.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberDao;
import service.MemberService;


@WebServlet("/Logcheck")
public class Logcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//계정정보 확인
		MemberService ms = new MemberService();
		//DB에서 사용자 정보 가져오기
		MemberDao md = new MemberDao();
		Member m = md.select(id);
		String name = m.getName();
		String grade = m.getGrade();		
		int result = ms.logcheck(id, pw);
		if(result == 1) {
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);
			request.setAttribute("name", name);
			request.setAttribute("grade", grade);
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			request.getRequestDispatcher("LoginClear.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("Login.jsp");
		}
		
		
		
		
	}

}
