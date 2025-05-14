package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testservlet
 */
@WebServlet("/test1")//객체 직렬화 -> 객체 압축
public class Test1servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//객체 신분증명 방법중 하나
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("doGet.......");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Index Page</h1>");
		out.print("<hr>");
		out.print("<p>Servlet을 배우고 있습니다.</p>");
		out.print("</body>");
		out.print("</html>");
		
		String name = request.getParameter("name");
		response.getWriter().append("name: "+name);
		System.out.println("doPost...");
	}


}
