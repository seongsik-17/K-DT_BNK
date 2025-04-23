package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/test3")
public class Test3servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Test3servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.sendRedirect("ex1.jsp");//서버가 요청 주소를 재귀한다 -> 도메인에 파라미터가 적시됨
		request.getRequestDispatcher("ex1.jsp").forward(request,response);
		//각각의 요청에 대응하면서 가용한 서버 자원을 미리 할당하여 관리
		//
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
