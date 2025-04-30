package control;

import java.io.IOException;

import VO.Board;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardDao;
import service.BoardService;


@WebServlet("/wbServlet")
public class WriteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDao dao = new BoardDao();
		Board b = new Board();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = (String) session.getAttribute("id");
		b.setTitle(title);
		b.setContent(content);
		b.setWriter(writer);
		dao.insertboard(b);
		
		request.setAttribute("title", title);
		
		request.getRequestDispatcher("Succeseinsert.jsp").forward(request, response);
		
		
	}

}
