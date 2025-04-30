
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadProc")
public class UploadProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uploadPath = request.getServletContext().getRealPath("/images/");
		System.out.println("uploadPath: " + uploadPath);

		String desc = request.getParameter("desc");
		System.out.println("desc: " + desc);

		Part part = request.getPart("imgfile");
		long size = part.getSize();

		if (size > 0) {
			part.write(uploadPath + part.getSubmittedFileName());
			part.delete();
			request.setAttribute("filename", part.getSubmittedFileName());
			request.getRequestDispatcher("success.jsp").forward(request, response);

		}else {
			response.sendRedirect("fail.jsp");
		}
	}

}
